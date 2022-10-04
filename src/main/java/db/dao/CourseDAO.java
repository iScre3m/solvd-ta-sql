package db.dao;

import db.ConnectionPool;
import db.models.Course;
import db.models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements IBaseDAO<Course> {

    private static final Logger LOGGER = LogManager.getLogger(CourseDAO.class.getName());
    private final String INSERT = "INSERT INTO Courses(startDate,name,cost) VALUES(?,?,?);";
    private final String UPDATE = "UPDATE Courses SET startDate = ?, name = ?, cost = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Courses WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Courses WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Courses ORDER BY id;";
    @Override
    public void insert(Course object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setDate(1, (Date) object.getStartDate());
            ps.setString(2, object.getName());
            ps.setDouble(3, object.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Course object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setDate(1, (Date) object.getStartDate());
            ps.setString(2, object.getName());
            ps.setDouble(3, object.getCost());
            ps.setInt(4, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Course ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update course ID: %d ", object.getId());
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
                String message = String.format("Course ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Course ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Course getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Course ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Course> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Course> courses = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                courses.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Course Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return courses;
    }

    private Course parser(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt(1));
        course.setStartDate(rs.getDate(2));
        course.setName(rs.getString(3));
        course.setCost(rs.getDouble(4));
        return course;
    }

    public List<Course> getByStudentId(int id) throws SQLException {
        String query = "SELECT c.id, c.startdate, c.name, c.cost FROM courses AS c INNER JOIN enrollments AS e ON e.courses_id = c.id INNER JOIN students AS s ON s.id = e.students_id AND s.id = ?;";
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Course> courses = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(query)){
            rs = ps.executeQuery();
            while (rs.next()){
                courses.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting Courses by student id failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return courses;
    }
}
