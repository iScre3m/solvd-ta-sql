package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "subject")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "specialityId" })
public class Subject {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "specialityId")
    private int specialityId;

    public Subject() {
    }

    public Subject(int id, String name, int specialityId) {
        this.id = id;
        this.name = name;
        this.specialityId = specialityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality=" + specialityId +
                '}';
    }
}
