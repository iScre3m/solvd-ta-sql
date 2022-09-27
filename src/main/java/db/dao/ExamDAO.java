package db.dao;

import db.ConnectionPool;
import db.models.Exam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO implements IBaseDAO<Exam>{

    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Exams(date,courses_id,subjects_id) VALUES(?,?,?);";
    private final String UPDATE = "UPDATE Exams SET date = ?, courses_id = ?, subjects_id = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Exams WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Exams WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Exams ORDER BY id;";
    @Override
    public void insert(Exam object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setDate(1, (Date) object.getDate());
            ps.setInt(2, object.getCourseId());
            ps.setInt(2, object.getSubjectId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Exam object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setDate(1, (Date) object.getDate());
            ps.setInt(2, object.getCourseId());
            ps.setInt(3, object.getSubjectId());
            ps.setInt(4, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Exams ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update exams ID: %d ", object.getId());
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
                String message = String.format("Exam ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Exam ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Exam getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Exam ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Exam> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Exam> exams = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                exams.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Exams Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return exams;
    }

    private Exam parser(ResultSet rs) throws SQLException {
        Exam exam = new Exam();
        exam.setId(rs.getInt(1));
        exam.setDate(rs.getDate(2));
        exam.setCourseId(rs.getInt(3));
        exam.setSubjectId(rs.getInt(4));
        return exam;
    }
}
