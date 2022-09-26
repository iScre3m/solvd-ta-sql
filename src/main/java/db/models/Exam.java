package db.models;

import java.time.LocalDate;
import java.util.Date;

public class Exam {
    private int id;
    private LocalDate date;
    private int courseId;
    private int subjectId;

    public Exam() {
    }

    public Exam(int id, LocalDate date, int courseId, int subjectId) {
        this.id = id;
        this.date = date;
        this.courseId = courseId;
        this.subjectId = subjectId;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", date=" + date +
                ", course=" + courseId +
                ", subject=" + subjectId +
                '}';
    }
}
