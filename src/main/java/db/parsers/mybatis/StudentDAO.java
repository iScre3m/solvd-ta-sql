package db.parsers.mybatis;

import db.models.Exam;
import db.models.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDAO implements IStudentMapper{
    @Override
    public void insert(Student student) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IStudentMapper.class).insert(student);
        session.commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IStudentMapper.class).update(student);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IStudentMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Student getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        Student student = session.getMapper(IStudentMapper.class).getById(id);
        session.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Student> students = session.getMapper(IStudentMapper.class).getAll();
        session.commit();
        session.close();
        return students;
    }
}
