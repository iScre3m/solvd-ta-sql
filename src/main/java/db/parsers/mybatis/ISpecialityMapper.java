package db.parsers.mybatis;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISpecialityMapper {
    String INSERT = "INSERT INSERT INTO Specialities(name,departments_id) VALUES(${name},${departments_id});";
    String UPDATE = "UPDATE Subjects SET name ${name}, departments_id = ${departments_id} WHERE id = ${id};";
    String DELETE = "DELETE FROM Subjects WHERE id = ${id};";
    String GET_BY_ID = "SELECT * FROM Subjects WHERE id = ${id};";
    String GET_ALL = "SELECT * FROM Subjects ORDER BY id;";

    @Insert(INSERT)
    void insert(Speciality speciality);

    @Update(UPDATE)
    void update(int id);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "departments_id", column = "departments_id"),
    })
    Speciality getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "departments_id", column = "departments_id"),
    })
    List<Speciality> getAll();
}
