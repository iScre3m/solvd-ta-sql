package db.parsers.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "exams")
@XmlAccessorType (XmlAccessType.FIELD)
public class Exams {

    @XmlElement(name = "exam")
    private List<Exam> exams = null;

    public List<Exam> getExams(){
        return exams;
    }

    public void setExams(List<Exam> exams){
        this.exams = exams;
    }

}
