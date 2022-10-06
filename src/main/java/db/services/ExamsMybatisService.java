package db.services;

import db.models.Exam;
import db.parsers.mybatis.ExamDAO;

import java.util.List;

public class ExamsMybatisService implements IService<Exam> {

    private ExamDAO examDAO = new ExamDAO();
    @Override
    public Exam getById(int id) {
        return examDAO.getById(id);
    }

    @Override
    public void insert(Exam exam){
        examDAO.insert(exam);
    }

    @Override
    public void delete(int id){
        examDAO.delete(id);
    }

    @Override
    public void update(Exam exam){
        examDAO.update(exam);
    }

    @Override
    public List<?> getAll(){
        return examDAO.getAll();
    }
}
