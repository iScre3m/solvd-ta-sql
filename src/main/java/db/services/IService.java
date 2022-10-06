package db.services;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {

    T getById(int id) throws SQLException;
    void insert(T t) throws SQLException;
    void delete(int id) throws SQLException;
    void update(T t) throws SQLException;
    List<?> getAll() throws SQLException;
}
