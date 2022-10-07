package db.dao;

import db.models.Class;

import java.sql.SQLException;
import java.util.List;

public interface IClassStudentId extends IBaseDAO<Class>{
    List<Class> getByStudentId(int id) throws SQLException;
}
