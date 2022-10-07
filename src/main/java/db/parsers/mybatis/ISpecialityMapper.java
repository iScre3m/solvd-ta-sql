package db.parsers.mybatis;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISpecialityMapper {
    String INSERT = "INSERT INTO Specialities(name,departments_id) VALUES(#{name},#{departmentId});";
    String UPDATE = "UPDATE Specialities SET name #{name}, departments_id = #{departmentId} WHERE id = #{id};";
    String DELETE = "DELETE FROM Specialities WHERE id = #{id};";
    String GET_BY_ID = "SELECT * FROM Specialities WHERE id = #{id};";
    String GET_ALL = "SELECT * FROM Specialities ORDER BY id;";

    @Insert(INSERT)
    void insert(Speciality speciality);

    @Update(UPDATE)
    void update(Speciality speciality);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "departmentId", column = "departments_id")
    })
    Speciality getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "departmentId", column = "departments_id")
    })
    List<Speciality> getAll();
}
