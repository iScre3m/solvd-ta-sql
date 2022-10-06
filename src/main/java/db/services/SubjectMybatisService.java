package db.services;

import db.models.Subject;
import db.parsers.mybatis.SubjectDAO;

import java.sql.SQLException;
import java.util.List;

public class SubjectMybatisService implements IService<Subject> {

    private SubjectDAO  subjectDAO = new SubjectDAO();
    @Override
    public Subject getById(int id) throws SQLException {
        return subjectDAO.getById(id);
    }

    @Override
    public void insert(Subject subject) throws SQLException {
        subjectDAO.insert(subject);
    }

    @Override
    public void delete(int id) throws SQLException {
        subjectDAO.delete(id);
    }

    @Override
    public void update(Subject subject) throws SQLException {
        subjectDAO.update(subject);
    }

    @Override
    public List<?> getAll() throws SQLException {
        return subjectDAO.getAll();
    }

}
