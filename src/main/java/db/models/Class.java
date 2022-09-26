package db.models;

import java.util.Date;
import java.util.List;

public class Class {
    private int id;
    private Professor professor;
    private Course course;
    private Date date;
    private Classroom classroom;
    private Subject subject;

    private List<Student> students;

    public Class() {
    }

    public Class(int id, Professor professor, Course course, Date date, Classroom classroom, Subject subject, List<Student> students) {
        this.id = id;
        this.professor = professor;
        this.course = course;
        this.date = date;
        this.classroom = classroom;
        this.subject = subject;
        this.students = students;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
                ", professor=" + professor +
                ", course=" + course +
                ", date=" + date +
                ", classroom=" + classroom +
                ", subject=" + subject +
                ", students=" + students +
                '}';
    }
}
