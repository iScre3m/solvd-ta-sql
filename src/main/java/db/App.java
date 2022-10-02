package db;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import db.parsers.*;
import db.parsers.jaxb.Exams;
import db.parsers.jaxb.Jaxb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class App {
    static Logger LOGGER = LogManager.getLogger(App.class.getName());
    private static final String EXAM_XML_PATH = "src/main/resources/files/exams.xml";
    private static final String SPECIALITY_XML_PATH = "src/main/resources/files/specialities.xml";
    private static final String SUBJECT_XML_PATH = "src/main/resources/files/subjects.xml";

    private static final String EXAM_JASB_XML = "src/main/resources/files/examsjaxb.xml";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws ParseException {

        xmlJaxbParsing();
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

    public static void xmlJaxbParsing(){
        try
        {
            Exams exams = new Exams();
            exams.setExams(new ArrayList<>());

            Exam exam = new Exam();
            exam.setId(1);
            exam.setDate(simpleDateFormat.parse("2022-10-14"));
            exam.setCourseId(1);
            exam.setSubjectId(8);

            Exam exam2 = new Exam();
            exam2.setId(2);
            exam2.setDate(simpleDateFormat.parse("2022-10-15"));
            exam2.setCourseId(2);
            exam2.setSubjectId(8);

            exams.getExams().add(exam);
            exams.getExams().add(exam2);

            Jaxb jaxb = new Jaxb();
            jaxb.marshalling(exams,EXAM_JASB_XML);
            Exams examsUnmarshalled = jaxb.unmarshalling(Exams.class,EXAM_JASB_XML);
            for(Exam examI : examsUnmarshalled.getExams())
            {
                System.out.println(examI.getId());
                System.out.println(simpleDateFormat.format(examI.getDate()));
                System.out.println(examI.getCourseId());
                System.out.println(examI.getSubjectId());
                System.out.println("-----------");
            }

        } catch (ParseException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }


}
