package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "specialities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Speciality {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "departmentId")
    private int departmentId;

    public Speciality() {
    }

    public Speciality(int id, String name, int departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + departmentId +
                '}';
    }
}
