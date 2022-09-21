package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    void insert(T object) throws SQLException;

    void update(T object) throws SQLException;

    void delete(int id) throws SQLException;

    T getById(int id) throws SQLException;

    List<T> getAll() throws SQLException;
}
