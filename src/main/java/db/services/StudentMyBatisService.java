package db.services;


import db.models.Student;
import db.parsers.mybatis.StudentDAO;

import java.util.List;

public class StudentMyBatisService implements IService<Student>{
    private StudentDAO studentDAO = new StudentDAO();
    @Override
    public Student getById(int id) {
        return studentDAO.getById(id);
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
    public List<Student> getAll(){
        return studentDAO.getAll();
    }
}
