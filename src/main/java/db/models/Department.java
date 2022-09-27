package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "departments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {

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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
