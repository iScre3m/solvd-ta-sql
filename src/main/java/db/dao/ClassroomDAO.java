package db.dao;

import db.ConnectionPool;
import db.models.Classroom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class ClassroomDAO implements IBaseDAO<Classroom> {
    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Classrooms VALUES(?,?)";
    private final String UPDATE = "UPDATE Classrooms SET size = ?, WHERE id = ?;";
    private final String DELETE = "DELETE FROM Classrooms WHERE id = ?";
    private final String GET_BY_ID = "SELECT * FROM Classrooms WHERE id = ?";
    private final String GET_ALL = "SELECT * FROM Classrooms ORDER BY id";
    @Override
    public void insert(Classroom object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, object.getSize());
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
    public void update(Classroom object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, object.getSize());
            ps.setInt(2, object.getId());

        }catch (SQLException e){

        }

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Classroom getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Classroom> getAll() throws SQLException {
        return null;
    }
    private Classroom parser(ResultSet rs) throws SQLException {
        Classroom classroom = new Classroom();
        classroom.setId(rs.getInt(1));
        classroom.setSize(rs.getInt(2));
        return classroom;
    }
}
