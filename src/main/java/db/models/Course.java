package db.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Course {
    private int id;
    private Date startDate;
    private String name;
    private double cost;
    private List<Student> students;

    public Course() {
    }

    public Course(int id, Date startDate, String name, double cost, List<Student> students) {
        this.id = id;
        this.startDate = startDate;
        this.name = name;
        this.cost = cost;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Course{" +
                "id=" + id +
                ", startDate=" + simpleDateFormat.format(startDate) +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", students=" + students +
                '}';
    }
}
