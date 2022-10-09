package db.parsers.mybatis;

import db.models.Class;
import db.models.Course;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassDAO implements IClassMapper{

    @Override
    public void insert(Class clas) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IClassMapper.class).insert(clas);
        session.commit();
        session.close();
    }

    @Override
    public void update(Class clas) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IClassMapper.class).update(clas);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IClassMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Class getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        Class clas = session.getMapper(IClassMapper.class).getById(id);
        session.commit();
        session.close();
        return clas;
    }

    @Override
    public List<Class> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Class> classes = session.getMapper(IClassMapper.class).getAll();
        session.commit();
        session.close();
        return classes;
    }

    @Override
    public List<Class> getByStudentId(int id) {
        SqlSession session = MyBatisFactory.getSession();
        List<Class> classes = session.getMapper(IClassMapper.class).getByStudentId(id);
        session.commit();
        session.close();
        return classes;
    }
}
