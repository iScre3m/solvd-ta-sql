package db.dao;

import db.ConnectionPool;
import db.models.Class;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IBaseDAO<Class> {

    private static final Logger LOGGER = LogManager.getLogger(ClassDAO.class.getName());
    private final String INSERT = "INSERT INTO Classes(professors_id,courses_id,date,classrooms_id,subjects_id) " + "VALUES(?,?,?,?,?);";
    private final String UPDATE = "UPDATE Classes SET professors_id = ?, courses_id = ?, date = ?, classrooms_id = ?, subjects_id = ?, WHERE id = ?;";
    private final String DELETE = "DELETE FROM Classes WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Classes WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Classes ORDER BY id;";

    @Override
    public void insert(Class object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(INSERT)) {
            ps.setInt(1, object.getProfessorId());
            ps.setInt(2, object.getCourseId());
            ps.setDate(3, (Date) object.getDate());
            ps.setInt(4, object.getClassroomId());
            ps.setInt(5, object.getSubjectId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed inserting record",e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public void update(Class object) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(UPDATE)){
            ps.setInt(1, object.getProfessorId());
            ps.setInt(2, object.getCourseId());
            ps.setDate(3, (Date) object.getDate());
            ps.setInt(4, object.getClassroomId());
            ps.setInt(5, object.getSubjectId());
            ps.setInt(6, object.getId());
            if(ps.executeUpdate()>0){
                String message = String.format("Class ID: %d was updated", object.getId());
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Couldn't update class ID: %d ", object.getId());
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
                String message = String.format("Class ID: %d was deleted", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Class ID: %d was not able to be deleted", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(c);
        }
    }

    @Override
    public Class getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GET_BY_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
        } catch (SQLException e) {
            String message = String.format("Failed getting Class ID: %d", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ConnectionPool.getInstance().releaseConnection(c);
        }
        return null;
    }

    @Override
    public List<Class> getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Class> classes = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_ALL)){
            rs = ps.executeQuery();
            while (rs.next()){
                classes.add(parser(rs));
            }
        }catch (SQLException e){
            LOGGER.error("Getting all records from Classes Table Failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return classes;
    }

    private Class parser(ResultSet rs) throws SQLException {
        Class clas = new Class();
        clas.setId(rs.getInt(1));
        clas.setProfessorId(rs.getInt(2));
        clas.setCourseId(rs.getInt(3));
        clas.setDate(rs.getDate(4));
        clas.setClassroomId(rs.getInt(5));
        clas.setSubjectId(rs.getInt(6));
        return clas;
    }
}
