package db.dao;

import db.ConnectionPool;
import db.models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IBaseDAO<Student>{

    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Students(firstName,lastName,email) VALUES(?,?,?);";
    private final String UPDATE = "UPDATE Students SET firstName = ?, lastName = ?, email = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Students WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Students WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Students ORDER BY id;";
    @Override
    public void insert(Student object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setString(1, object.getFirstName());
            ps.setString(2, object.getLastName());
            ps.setString(3, object.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Student object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setString(1, object.getFirstName());
            ps.setString(2, object.getLastName());
            ps.setString(3, object.getEmail());
            ps.setInt(4, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Student ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update student ID: %d ", object.getId());
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
                String message = String.format("Student ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Student ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Student getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Student ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Student> students = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                students.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Student Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return students;
    }

    private Student parser(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setFirstName(rs.getString(2));
        student.setLastName(rs.getString(3));
        student.setEmail(rs.getString(4));
        return student;
    }
}
