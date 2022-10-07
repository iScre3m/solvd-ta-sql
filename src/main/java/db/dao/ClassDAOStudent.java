package db.dao;

import db.ConnectionPool;
import db.models.Class;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAOStudent extends ClassDecorator{

    private static final Logger LOGGER = LogManager.getLogger(ClassDecorator.class.getName());

    private final String GET_BY_STUDENT_ID = "SELECT classes.id, classes.professors_id,classes.courses_id,classes.date,classes.classrooms_id,classes.subjects_id FROM classes JOIN group_of_students ON group_of_students.classes_id = classes.id JOIN students ON students.id = group_of_students.students_id AND students.id = ?";

    public ClassDAOStudent(IClassStudentId classDecorated) {
        super(classDecorated);
    }

    public List<Class> getByStudentId(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        ResultSet rs = null;
        ArrayList<Class> classes = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement(GET_BY_STUDENT_ID)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Class clas = new Class();
                clas.setId(rs.getInt(1));
                clas.setProfessorId(rs.getInt(2));
                clas.setCourseId(rs.getInt(3));
                clas.setDate(rs.getDate(4));
                clas.setClassroomId(rs.getInt(5));
                clas.setSubjectId(rs.getInt(6));
                classes.add(clas);
            }
        }catch (SQLException e){
            LOGGER.error("Getting Classes by student id failed", e);
        }finally {
            ConnectionPool.getInstance().releaseConnection(c);
            assert rs != null;
            rs.close();
        }
        return classes;
    }
}
