package db.models;

import java.util.Date;
import java.util.List;

public class Class {
    private int id;
    private int professorId;
    private int courseId;
    private Date date;
    private int classroomId;
    private int subjectId;
    private List<Student> students;

    public Class() {
    }

    public Class(int id, int professorId, int courseId, Date date, int classroomId, int subjectId, List<Student> students) {
        this.id = id;
        this.professorId = professorId;
        this.courseId = courseId;
        this.date = date;
        this.classroomId = classroomId;
        this.subjectId = subjectId;
        this.students = students;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", professor=" + professorId +
                ", course=" + courseId +
                ", date=" + date +
                ", classroom=" + classroomId +
                ", subject=" + subjectId +
                ", students=" + students +
                '}';
    }
}
