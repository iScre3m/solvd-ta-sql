package db.dao;

import db.ConnectionPool;
import db.models.Class;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Class getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Class> getAll() throws SQLException {
        return null;
    }
}
