package db.parsers.mybatis;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;

import java.util.List;

public class MyBatisRunner {
    public static void main(String[] args) {
        Subject subject = new SubjectDAO().getById(1);
        System.out.println(subject);

        List<Speciality> specialities = new SpecialityDAO().getAll();
        for (Speciality speciality: specialities) {
            System.out.println(speciality);
        }

        Exam exam = new ExamDAO().getById(3);
        System.out.println(exam);
    }
}
