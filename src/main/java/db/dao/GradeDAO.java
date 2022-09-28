package db.dao;

import db.ConnectionPool;
import db.models.Exam;
import db.models.Grade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO implements IBaseDAO<Grade> {

    private static final Logger LOGGER = LogManager.getLogger(GradeDAO.class.getName());
    private final String INSERT = "INSERT INTO Grades(students_id,exams_id,grade) VALUES(?,?,?);";
    private final String UPDATE = "UPDATE Grades SET students_id = ?, exams_id = ?, grade = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Grades WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Grades WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Grades ORDER BY id;";

    @Override
    public void insert(Grade object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setInt(1, object.getStudentId());
            ps.setInt(2, object.getExamId());
            ps.setInt(3, object.getGrade());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Grade object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setInt(1, object.getStudentId());
            ps.setInt(2, object.getExamId());
            ps.setInt(3, object.getGrade());
            ps.setInt(4, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Grades ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update grades ID: %d ", object.getId());
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
                String message = String.format("Grade ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Grade ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Grade getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Grade ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Grade> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Grade> grades = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                grades.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Grade Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return grades;
    }

    private Grade parser(ResultSet rs) throws SQLException {
        Grade grade = new Grade();
        grade.setId(rs.getInt(1));
        grade.setStudentId(rs.getInt(2));
        grade.setExamId(rs.getInt(3));
        grade.setGrade(rs.getInt(4));
        return grade;
    }
}
