package db.parsers.mybatis;

import db.models.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClassMapper {
    String INSERT = "INSERT INTO Classes(Professors_id,Courses_id,date,Classrooms_id,Subjects_id) VALUES(${professorId},#{courseId},#{date},#{classroomId},#{subjectId});";
    String UPDATE = "UPDATE Classes SET Professors_id = #{professorId}, Courses_id = #{courseId}, date = #{date}, Classrooms_id = #{classroomId}, Subjects_id = #{subjectId} WHERE id = ${id};";
    String DELETE = "DELETE FROM Classes WHERE id = #{id};";
    String GET_BY_ID = "SELECT * FROM Classes WHERE id = #{id};";
    String GET_ALL = "SELECT * FROM Classes ORDER BY id;";
    String GET_BY_STUDENT_ID = "SELECT Classes.id, Classes.professors_id,Classes.courses_id,Classes.date,Classes.classrooms_id,Classes.subjects_id FROM Classes JOIN Group_of_Students ON Group_of_Students.classes_id = Classes.id JOIN Students ON Students.id = Group_of_Students.Students_id AND Students.id = #{id}";


    @Insert(INSERT)
    void insert(Class clas);

    @Update(UPDATE)
    void update(Class clas);

    @Delete(DELETE)
    void delete(int id);

    @Select(GET_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "professorId", column = "Professors_id"),
            @Result(property = "courseId", column = "Courses_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "classroomId", column = "Classrooms_id"),
            @Result(property = "subjectId", column = "Subjects_id")
    })
    Class getById(int id);

    @Select(GET_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "professorId", column = "Professors_id"),
            @Result(property = "courseId", column = "Courses_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "classroomId", column = "Classrooms_id"),
            @Result(property = "subjectId", column = "Subjects_id")
    })
    List<Class> getAll();

    @Select(GET_BY_STUDENT_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "professorId", column = "Professors_id"),
            @Result(property = "courseId", column = "Courses_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "classroomId", column = "Classrooms_id"),
            @Result(property = "subjectId", column = "Subjects_id")
    })
    List<Class> getByStudentId(int id);
}
