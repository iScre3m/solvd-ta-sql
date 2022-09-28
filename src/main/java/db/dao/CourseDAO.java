package db.dao;

import db.models.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CourseDAO implements IBaseDAO<Course> {

    private static final Logger LOGGER = LogManager.getLogger(CourseDAO.class.getName());
    private final String INSERT = "INSERT INTO Students(firstName,lastName,email) VALUES(?,?,?);";
    private final String UPDATE = "UPDATE Students SET firstName = ?, lastName = ?, email = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM Students WHERE id = ?;";
    private final String GET_BY_ID = "SELECT * FROM Students WHERE id = ?;";
    private final String GET_ALL = "SELECT * FROM Students ORDER BY id;";
    @Override
    public void insert(Course object) throws SQLException {

    }

    @Override
    public void update(Course object) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Course getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Course> getAll() throws SQLException {
        return null;
    }
}
