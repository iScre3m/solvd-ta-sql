package db;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import db.parsers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    static Logger LOGGER = LogManager.getLogger(App.class.getName());
    private static final String EXAM_XML_PATH = "src/main/resources/files/exams.xml";
    private static final String SPECIALITY_XML_PATH = "src/main/resources/files/specialities.xml";
    private static final String SUBJECT_XML_PATH = "src/main/resources/files/subjects.xml";

    public static void main(String[] args) throws ParseException {

        //xmlSaxParsing();

    }

    public static void xmlSaxParsing(){
        Exam exam = new ParserSAX().parse(EXAM_XML_PATH, new ExamHandler()).getExam();
        System.out.printf("Parsed exam: %s\n", exam);
        Speciality speciality = new ParserSAX().parse(SPECIALITY_XML_PATH, new SpecialityHandler()).getSpeciality();
        System.out.printf("Parsed speciality: %s\n", speciality);
        Subject subject = new ParserSAX().parse(SUBJECT_XML_PATH, new SubjectHandler()).getSubject();
        System.out.printf("Parsed speciality: %s\n", subject);
    }


}
