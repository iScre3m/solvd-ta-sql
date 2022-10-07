package db.services;

import db.dao.*;
import db.models.Class;
import db.models.Course;
import db.models.Student;
import java.sql.SQLException;
import java.util.List;

public class StudentMysqlService implements IService<Student>{

    private StudentDAO studentDAO = new StudentDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private ClassDAO classDAO = new ClassDAO();

    private IClassStudentId classDAOStudent = new ClassDAOStudent((IClassStudentId) classDAO);


    public Student getById(int id) throws SQLException {
        Student student = studentDAO.getById(id);

        List<Course> courses = courseDAO.getByStudentId(id);
        student.setCourses(courses);

        List<Class> classes = classDAOStudent.getByStudentId(id);
        student.setClasses(classes);

        return student;
    }
    @Override
    public void delete(int id) throws SQLException {
        studentDAO.delete(id);
    }
    @Override
    public void insert(Student student) throws SQLException {
        studentDAO.insert(student);
    }
    @Override
    public void update(Student student) throws SQLException {
        studentDAO.update(student);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return studentDAO.getAll();
    }
}
