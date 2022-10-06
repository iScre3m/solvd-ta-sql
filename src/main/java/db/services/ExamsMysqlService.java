package db.services;

import db.dao.ExamDAO;
import db.models.Exam;

import java.sql.SQLException;
import java.util.List;

public class ExamsMysqlService implements IService<Exam>{
    private ExamDAO examDAO = new ExamDAO();
    @Override
    public Exam getById(int id) throws SQLException {
        return examDAO.getById(id);
    }

    @Override
    public void insert(Exam exam) throws SQLException {
        examDAO.insert(exam);
    }

    @Override
    public void delete(int id) throws SQLException {
        examDAO.delete(id);
    }

    @Override
    public void update(Exam exam) throws SQLException {
        examDAO.update(exam);
    }

    @Override
    public List<?> getAll() throws SQLException {
        return examDAO.getAll();
    }
}
