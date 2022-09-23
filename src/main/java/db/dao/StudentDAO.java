package db.dao;

import db.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements IBaseDAO<Student>{
    @Override
    public void insert(Student object) throws SQLException {

    }

    @Override
    public void update(Student object) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Student getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return null;
    }
}
