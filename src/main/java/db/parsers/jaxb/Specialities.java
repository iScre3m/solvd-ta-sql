package db.parsers.jaxb;

import db.models.Speciality;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "specialities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Specialities {

    @XmlElement(name = "speciality")
    private List<Speciality> specialities = null;

    public List<Speciality> getSpecialities(){
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities){
        this.specialities = specialities;
    }

}
