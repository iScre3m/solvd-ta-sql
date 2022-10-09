package db.parsers.mybatis;

import db.models.Course;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseDAO implements ICourseMapper{
    @Override
    public void insert(Course course) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ICourseMapper.class).insert(course);
        session.commit();
        session.close();
    }

    @Override
    public void update(Course course) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ICourseMapper.class).update(course);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ICourseMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Course getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        Course course = session.getMapper(ICourseMapper.class).getById(id);
        session.commit();
        session.close();
        return course;
    }

    @Override
    public List<Course> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Course> courses = session.getMapper(ICourseMapper.class).getAll();
        session.commit();
        session.close();
        return courses;
    }

    @Override
    public List<Course> getByStudentId(int id) {
        SqlSession session = MyBatisFactory.getSession();
        List<Course> courses = session.getMapper(ICourseMapper.class).getByStudentId(id);
        session.commit();
        session.close();
        return courses;
    }
}
