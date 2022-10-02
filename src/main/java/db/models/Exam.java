package db.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import db.parsers.DateAdapter;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonPropertyOrder({"id","date","courseId","subjectId"})
@XmlRootElement(name = "exam")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "date", "courseId", "subjectId" })
public class Exam {
    @JsonProperty
    @XmlElement(name = "id")
    private int id;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @XmlElement(name = "date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    @JsonProperty
    @XmlElement(name = "courseId")
    private int courseId;
    @JsonProperty
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Exam{" +
                "id=" + id +
                ", date=" + simpleDateFormat.format(date) +
                ", course=" + courseId +
                ", subject=" + subjectId +
                '}';
    }
}
