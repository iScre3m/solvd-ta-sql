package db.models;

public class Grade {
    private int id;
    private int studentId;
    private int examId;
    private int grade;

    public Grade() {
    }

    public Grade(int id, int studentId, int examId, int grade) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExam() {
        return examId;
    }

    public void setExam(int examId) {
        this.examId = examId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + studentId +
                ", exam=" + examId +
                ", grade=" + grade +
                '}';
    }
}
