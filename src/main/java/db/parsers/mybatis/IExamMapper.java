package db.parsers.mybatis;

import db.models.Exam;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IExamMapper {
    String INSERT = "INSERT INTO Exams(date,courses_id,subjects_id) VALUES(${date},${courses_id},${subjects_id});";
    String UPDATE = "UPDATE Exams SET date = ${date}, courses_id = ${courses_id}, subjects_id = ${subjects_id} WHERE id = ${id};";
    String DELETE = "DELETE FROM Exams WHERE id = ${id};";
    String GET_BY_ID = "SELECT * FROM Exams WHERE id = ${id};";
    String GET_ALL = "SELECT * FROM Exams ORDER BY id;";

    @Insert(INSERT)
    void insert(Exam exam);

    @Update(UPDATE)
    void update(int id);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "courses_id", column = "courses_id"),
            @Result(property = "subjects_id", column = "subjects_id"),
    })
    Exam getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "courses_id", column = "courses_id"),
            @Result(property = "subjects_id", column = "subjects_id"),
    })
    List<Exam> getAll();
}
