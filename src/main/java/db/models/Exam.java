package db.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement(name = "exam")
@XmlAccessorType(XmlAccessType.FIELD)
public class Exam {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "date")
    private Date date;
    @XmlElement(name = "courseId")
    private int courseId;
    @XmlElement(name = "subjectId")
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
