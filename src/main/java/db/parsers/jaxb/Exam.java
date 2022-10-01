package db.parsers.jaxb;


import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "exam")
@XmlType(propOrder = { "id", "date", "courseId", "subjectId" })
@XmlAccessorType (XmlAccessType.FIELD)
public class Exam {

    private int id;

    private Date date;

    private int courseId;

    private int subjectId;

    public Exam() {
    }

    public Exam(int id, Date date, int courseId, int subjectId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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