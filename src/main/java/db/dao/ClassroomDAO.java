package db.dao;

import db.ConnectionPool;
import db.models.Classroom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements IBaseDAO<Classroom> {
    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Classrooms(size) VALUES(?);";
    private final String UPDATE = "UPDATE Classrooms SET size = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Classrooms WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Classrooms WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Classrooms ORDER BY id;";
    @Override
    public void insert(Classroom object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setInt(1, object.getSize());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Classroom object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setInt(1, object.getSize());
            ps.setInt(2, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Classroom ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update classroom ID: %d ", object.getId());
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(DELETE)){
            ps.setInt(1,id);
            if(ps.executeUpdate()>0){
                String message = String.format("Classroom ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Classroom ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Classroom getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Classroom ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Classroom> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Classroom> classrooms = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                classrooms.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Classrooms Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return classrooms;
    }
    private Classroom parser(ResultSet rs) throws SQLException {
        Classroom classroom = new Classroom();
        classroom.setId(rs.getInt(1));
        classroom.setSize(rs.getInt(2));
        return classroom;
    }
}
