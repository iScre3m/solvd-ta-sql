package db.services;

import db.dao.SubjectDAO;
import db.models.Subject;

import java.sql.SQLException;
import java.util.List;

public class SubjectMysqlService {
    private SubjectDAO subjectDAO = new SubjectDAO();

    public Subject getById(int id) throws SQLException {
        return subjectDAO.getById(id);
    }

    public void insert(Subject subject) throws SQLException {
        subjectDAO.insert(subject);
    }

    public void delete(int id) throws SQLException {
        subjectDAO.delete(id);
    }

    public void update(Subject subject) throws SQLException {
        subjectDAO.update(subject);
    }

    public List<Subject> getAll() throws SQLException {
        return subjectDAO.getAll();
    }
}
