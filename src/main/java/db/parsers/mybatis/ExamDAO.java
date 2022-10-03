package db.parsers.mybatis;

import db.models.Exam;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExamDAO implements IExamMapper{
    @Override
    public void insert(Exam exam) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IExamMapper.class).insert(exam);
        session.commit();
        session.close();
    }

    @Override
    public void update(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IExamMapper.class).update(id);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IExamMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Exam getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        Exam exam = session.getMapper(IExamMapper.class).getById(id);
        session.commit();
        session.close();
        return exam;
    }

    @Override
    public List<Exam> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Exam> exams = session.getMapper(IExamMapper.class).getAll();
        session.commit();
        session.close();
        return exams;
    }
}
