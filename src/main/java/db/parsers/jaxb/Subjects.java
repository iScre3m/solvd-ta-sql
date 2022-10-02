package db.parsers.jaxb;

import db.models.Subject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "subjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subjects {

    @XmlElement(name = "subject")
    private List<Subject> subjects = null;

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setSubjects(List<Subject> subjects){
        this.subjects = subjects;
    }

}
