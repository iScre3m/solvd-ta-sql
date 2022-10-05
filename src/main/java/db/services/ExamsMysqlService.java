package db.services;

import db.dao.ExamDAO;
import db.models.Exam;

import java.sql.SQLException;
import java.util.List;

public class ExamsMysqlService {
    private ExamDAO examDAO = new ExamDAO();

    public Exam getById(int id) throws SQLException {
        return examDAO.getById(id);
    }

    public void insert(Exam exam) throws SQLException {
        examDAO.insert(exam);
    }

    public void delete(int id) throws SQLException {
        examDAO.delete(id);
    }

    public void update(Exam exam) throws SQLException {
        examDAO.update(exam);
    }

    public List<Exam> getAll() throws SQLException {
        return examDAO.getAll();
    }

}
