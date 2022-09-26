package db.models;

public class Subject {
    private int id;
    private String name;
    private Speciality speciality;

    public Subject() {
    }

    public Subject(int id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
