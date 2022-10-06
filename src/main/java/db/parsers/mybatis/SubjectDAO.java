package db.parsers.mybatis;

import db.models.Subject;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubjectDAO implements ISubjectMapper{

    @Override
    public void insert(Subject subject) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISubjectMapper.class).insert(subject);
        session.commit();
        session.close();
    }

    @Override
    public void update(Subject subject) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISubjectMapper.class).update(subject);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISubjectMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Subject getById(int id) {
        Subject subject = new Subject();
        try (SqlSession session = MyBatisFactory.getSession()) {
            ISubjectMapper mapper = session.getMapper(ISubjectMapper.class);
            subject = mapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public List<Subject> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Subject> subjects = session.getMapper(ISubjectMapper.class).getAll();
        session.commit();
        session.close();
        return subjects;
    }
}
