package db.models;

public class Professor {
    private int id;
    private String firstName;
    private String lastName;
    private String degree;

    public Professor() {
    }

    public Professor(int id, String firstName, String lastName, String degree) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
