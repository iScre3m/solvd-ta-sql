package db.services;


import db.dao.ClassDAO;
import db.dao.CourseDAO;
import db.models.Class;
import db.models.Course;
import db.models.Student;
import db.parsers.mybatis.StudentDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMyBatisService implements IService<Student>{
    private StudentDAO studentDAO = new StudentDAO();
    private ClassDAO classDAO = new ClassDAO();
    private CourseDAO courseDAO = new CourseDAO();

    @Override
    public Student getById(int id) throws SQLException {
        Student student = studentDAO.getById(id);

        List<Course> courses = courseDAO.getByStudentId(id);
        student.setCourses(courses);

        List<Class> classes = classDAO.getByStudentId(id);
        student.setClasses(classes);

        return student;
    }

    @Override
    public void insert(Student student){
        studentDAO.insert(student);
    }

    @Override
    public void delete(int id){
        studentDAO.delete(id);
    }

    @Override
    public void update(Student student){
        studentDAO.update(student);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> students = studentDAO.getAll();

        for (Student student : students) {
            int studentId = student.getId();
            List<Course> courses = courseDAO.getByStudentId(studentId);
            student.setCourses(courses);

            List<Class> classes = classDAO.getByStudentId(studentId);
            student.setClasses(classes);
        }

        return students;
    }
}
