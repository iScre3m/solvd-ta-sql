package db.parsers.mybatis;

import db.models.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICourseMapper {
    String INSERT = "INSERT INTO Courses(startDate,name,cost) VALUES(${startDate},#{name},#{cost});";
    String UPDATE = "UPDATE Courses SET startDate = #{startDate}, name = #{name}, cost = #{cost} WHERE id = ${id};";
    String DELETE = "DELETE FROM Courses WHERE id = #{id};";
    String GET_BY_ID = "SELECT * FROM Courses WHERE id = #{id};";
    String GET_ALL = "SELECT * FROM Courses ORDER BY id;";
    String GET_BY_STUDENT_ID = "SELECT Courses.id,Courses.startDate,Courses.name,Courses.cost FROM Courses JOIN Enrollments ON Enrollments.courses_id = Courses.id JOIN Students ON Students.id = Enrollments.students_id AND Students.id = #{id};";


    @Insert(INSERT)
    void insert(Course course);

    @Update(UPDATE)
    void update(Course course);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "name", column = "name"),
            @Result(property = "cost", column = "cost")
    })
    Course getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "name", column = "name"),
            @Result(property = "cost", column = "cost")
    })
    List<Course> getAll();

    @Select(GET_BY_STUDENT_ID)
    @Results(value = {
            @Result(property = "id",column = "id"),
            @Result(property = "startDate",column = "startDate"),
            @Result(property = "name",column = "name"),
            @Result(property = "cost",column = "cost")
    })
    List<Course> getByStudentId(int id);
}
