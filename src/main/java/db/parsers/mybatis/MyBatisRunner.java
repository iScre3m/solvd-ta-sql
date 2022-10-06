package db.parsers.mybatis;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MyBatisRunner {
    static Logger LOGGER = LogManager.getLogger(MyBatisRunner.class.getName());

    public static void main(String[] args) {
        Subject subject = new SubjectDAO().getById(1);
        LOGGER.info(subject);

        List<Speciality> specialities = new SpecialityDAO().getAll();
        for (Speciality speciality: specialities) {
            LOGGER.info(speciality);
        }

        Exam exam = new ExamDAO().getById(3);
        LOGGER.info(exam);

    }
}
