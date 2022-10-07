package db.dao;

import db.models.Class;
import db.models.Student;

import java.sql.SQLException;
import java.util.List;

public abstract class ClassDecorator implements IClassStudentId{

    protected IClassStudentId ClassDecorated;

    public ClassDecorator(IClassStudentId classDecorated) {
        ClassDecorated = classDecorated;
    }

    @Override
    public void insert(Class object) throws SQLException {
        this.ClassDecorated.insert(object);
    }

    @Override
    public void update(Class object) throws SQLException {
        this.ClassDecorated.update(object);
    }

    @Override
    public void delete(int id) throws SQLException {
        this.ClassDecorated.delete(id);
    }

    @Override
    public Class getById(int id) throws SQLException {
        return this.ClassDecorated.getById(id);
    }

    @Override
    public List<Class> getAll() throws SQLException {
        return this.ClassDecorated.getAll();
    }
}
