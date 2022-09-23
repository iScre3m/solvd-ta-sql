package db.dao;

import db.ConnectionPool;
import db.models.Class;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class ClassDAO implements IBaseDAO<Class> {

    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Classes(Professors_id,Courses_id,date,Classrooms_id,Subjects_id) " + "VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE Classes SET Professors_id = ?, Courses_id = ?, date = ?, Classrooms_id = ?, Subjects_id = ?, WHERE id = ?;";
    private final String DELETE = "DELETE FROM Classes WHERE id = ?";
    private final String GET_BY_ID = "SELECT * FROM Classes WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Classes ORDER BY id";

    @Override
    public void insert(Class object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, object.getProfessor().getId());
            ps.setInt(2, object.getCourse().getId());
            ps.setDate(3, Date.valueOf(object.getDate())); // ask how to work with LocalDate
            ps.setInt(4, object.getClassroom().getId());
            ps.setInt(5, object.getSubject().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        throw new SQLException("Could not get ID of newly created object");
    }

    @Override
    public void update(Class object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, object.getProfessor().getId());
            ps.setInt(2, object.getCourse().getId());
            ps.setDate(3, Date.valueOf(object.getDate())); // ask how to work with LocalDate
            ps.setInt(4, object.getClassroom().getId());
            ps.setInt(5, object.getSubject().getId());
            ps.setInt(6, object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(DELETE);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            try{
                ps.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
        }
    }

    @Override
    public Class getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Class object = new Class(rs.getInt("Professors_id"), rs.getInt("Courses_id"),
                        rs.getDate("date"), rs.getInt("Classrooms_id"), rs.getInt("Subjects_id"));
                object.setId(id);
                object.setDate(rs.getDate("date"));
                return object;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        throw new SQLException("No data matching the ID given");
    }

    @Override
    public List<Class> getAll() throws SQLException {
        return null;
    }
}
