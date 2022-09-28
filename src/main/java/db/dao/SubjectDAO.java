package db.dao;

import db.ConnectionPool;
import db.models.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements IBaseDAO<Subject>{

    private static final Logger LOGGER = LogManager.getLogger(SubjectDAO.class.getName());
    private final String INSERT = "INSERT INTO Subjects(name,specialities_id) VALUES(?,?);";
    private final String UPDATE = "UPDATE Subjects SET name = ?, specialities_id = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Subjects WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Subjects WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Subjects ORDER BY id;";
    @Override
    public void insert(Subject object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setString(1, object.getName());
            ps.setInt(2, object.getSpecialityId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Subject object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setString(1, object.getName());
            ps.setInt(2, object.getSpecialityId());
            ps.setInt(3, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Subject ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update subject ID: %d ", object.getId());
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
                String message = String.format("Subject ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Subject ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Subject getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Subject ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Subject> subjects = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                subjects.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Subjects Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return subjects;
    }

    private Subject parser(ResultSet rs) throws SQLException {
        Subject subject = new Subject();
        subject.setId(rs.getInt(1));
        subject.setName(rs.getString(2));
        subject.setSpecialityId(rs.getInt(3));
        return subject;
    }
}
