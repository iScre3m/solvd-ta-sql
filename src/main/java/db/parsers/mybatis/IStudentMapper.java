package db.parsers.mybatis;

import db.models.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IStudentMapper {
    String INSERT = "INSERT INTO Students(firstName,lastName,email) VALUES(#{firstName},#{lastName},#{email});";
    String UPDATE = "UPDATE Students SET firstName = #{firstName}, lastName = #{lastName}, email = #{email} WHERE id = #{id};";
    String DELETE = "DELETE FROM Students WHERE id = #{id};";
    String GET_BY_ID = "SELECT * FROM Students WHERE id = #{id};";
    String GET_ALL = "SELECT * FROM Students ORDER BY id;";

    @Insert(INSERT)
    void insert(Student student);

    @Update(UPDATE)
    void update(Student student);

    @Delete(DELETE)
    void delete(int id);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "email", column = "email")
    })
    @Select(GET_BY_ID)
    Student getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "email", column = "email")
    })
    List<Student> getAll();
}
