package db.models;

import java.time.LocalDate;
import java.util.Date;

public class Exam {
    private int id;
    private LocalDate date;
    private Course course;
    private Subject subject;

    public Exam(int id, LocalDate date, Course course, Subject subject) {
        this.id = id;
        this.date = date;
        this.course = course;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", date=" + date +
                ", course=" + course +
                ", subject=" + subject +
                '}';
    }
}
