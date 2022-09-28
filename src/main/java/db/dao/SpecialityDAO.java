package db.dao;

import db.ConnectionPool;
import db.models.Speciality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAO implements IBaseDAO<Speciality> {
    private static final Logger LOGGER = LogManager.getLogger(SpecialityDAO.class.getName());
    private final String INSERT = "INSERT INTO Specialities(name,departments_id) VALUES(?,?);";
    private final String UPDATE = "UPDATE Specialities SET name = ?, departments_id = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Specialities WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Specialities WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Specialities ORDER BY id;";
    @Override
    public void insert(Speciality object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setString(1, object.getName());
            ps.setInt(2, object.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Speciality object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setString(1, object.getName());
            ps.setInt(2,object.getDepartmentId());
            ps.setInt(3, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Speciality ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update speciality ID: %d ", object.getId());
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
                String message = String.format("Speciality ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Speciality ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Speciality getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Speciality ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Speciality> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Speciality> specialities = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                specialities.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Specialities Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return specialities;
    }

    private Speciality parser(ResultSet rs) throws SQLException {
        Speciality speciality = new Speciality();
        speciality.setId(rs.getInt(1));
        speciality.setName(rs.getString(2));
        speciality.setDepartmentId(rs.getInt(3));
        return speciality;
    }
}
