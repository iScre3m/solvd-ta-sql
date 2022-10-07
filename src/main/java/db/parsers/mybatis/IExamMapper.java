package db.parsers.mybatis;

import db.models.Exam;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IExamMapper {
    String INSERT = "INSERT INTO Exams(date,courses_id,subjects_id) VALUES(${date},#{courseId},#{subjectId});";
    String UPDATE = "UPDATE Exams SET date = #{date}, courses_id = #{courseId}, subjects_id = #{subjectId} WHERE id = ${id};";
    String DELETE = "DELETE FROM Exams WHERE id = #{id};";
    String GET_BY_ID = "SELECT * FROM Exams WHERE id = #{id};";
    String GET_ALL = "SELECT * FROM Exams ORDER BY id;";

    @Insert(INSERT)
    void insert(Exam exam);

    @Update(UPDATE)
    void update(Exam exam);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "courseId", column = "courses_id"),
            @Result(property = "subjectId", column = "subjects_id")
    })
    Exam getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "courseId", column = "courses_id"),
            @Result(property = "subjectId", column = "subjects_id")
    })
    List<Exam> getAll();
}
