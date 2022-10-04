package db;

import db.models.Exam;
import db.models.Speciality;
import db.models.Subject;
import db.parsers.jaxb.Exams;
import db.parsers.jaxb.Jaxb;
import db.parsers.jaxb.Specialities;
import db.parsers.jaxb.Subjects;
import db.parsers.mybatis.SpecialityDAO;
import db.parsers.mybatis.SubjectDAO;
import db.parsers.sax.ExamHandler;
import db.parsers.sax.SpecialityHandler;
import db.parsers.sax.SubjectHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class App {
    static Logger LOGGER = LogManager.getLogger(App.class.getName());
    private static final String EXAM_XML_PATH = "src/main/resources/files/exams.xml";
    private static final String SPECIALITY_XML_PATH = "src/main/resources/files/specialities.xml";
    private static final String SUBJECT_XML_PATH = "src/main/resources/files/subjects.xml";

    private static final String SUBJECT_JSON_PATH = "src/main/resources/files/subjects.json";

    private static final String EXAM_JAXB_XML = "src/main/resources/files/examsjaxb.xml";
    private static final String SUBJ_JAXB_XML = "src/main/resources/files/subjectsjaxb.xml";
    private static final String SPEC_JAXB_XML = "src/main/resources/files/specialitiesjaxb.xml";

    private static final String SUBJ_JACKSON_JSON = "src/main/resources/files/subjectsjackson.json";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //xmlJaxbParsing();
        //xmlSaxParsing();
        Subject subject = new SubjectDAO().getById(1);
        System.out.println(subject);

    }

    public static void xmlSaxParsing() throws ParserConfigurationException, IOException, SAXException {
        ExamHandler examHandler = new ExamHandler();
        List<Exam> exams = examHandler.readDataFromXML(EXAM_XML_PATH);
        for (Exam exam: exams) {
            System.out.println(exam);
        }
        SpecialityHandler specialityHandler = new SpecialityHandler();
        List<Speciality> specialities = specialityHandler.readDataFromXML(SPECIALITY_XML_PATH);
        for (Speciality speciality: specialities) {
            System.out.println(speciality);
        }
        SubjectHandler subjectHandler = new SubjectHandler();
        List<Subject> subjects = subjectHandler.readDataFromXML(SUBJECT_XML_PATH);
        for (Subject subject: subjects) {
            System.out.println(subject);
        }
        }

    public static void xmlJaxbParsing(){
        try
        {
            Exams exams = new Exams();
            exams.setExams(new ArrayList<>());

            Exam exam = new Exam(1,simpleDateFormat.parse("2022-10-14"),1,8);

            Exam exam2 = new Exam(2,simpleDateFormat.parse("2022-10-15"),2,8);
            exams.getExams().add(exam);
            exams.getExams().add(exam2);

            Subjects subjects = new Subjects();
            subjects.setSubjects(new ArrayList<>());

            Subject subject = new Subject(1,"Mathematics",1);
            Subject subject2 = new Subject(2,"Computing",1);
            Subject subject3 = new Subject(3,"Administration",2);
            subjects.getSubjects().add(subject);
            subjects.getSubjects().add(subject2);
            subjects.getSubjects().add(subject3);

            Specialities specialities = new Specialities();
            specialities.setSpecialities(new ArrayList<>());

            Speciality speciality = new Speciality(1,"Informatics Engineering",1);
            Speciality speciality2 = new Speciality(2,"Accountant",1);
            specialities.getSpecialities().add(speciality);
            specialities.getSpecialities().add(speciality2);

            Jaxb jaxb = new Jaxb();
            jaxb.marshalling(exams,EXAM_JAXB_XML);
            Exams examsUnmarshalled = jaxb.unmarshalling(Exams.class,EXAM_JAXB_XML);
            for(Exam examI : examsUnmarshalled.getExams())
            {
                System.out.println(examI);
            }

            jaxb.marshalling(subjects,SUBJ_JAXB_XML);
            Subjects subjectsUnmarshalled = jaxb.unmarshalling(Subjects.class,SUBJ_JAXB_XML);
            for(Subject subjectI : subjectsUnmarshalled.getSubjects())
            {
                System.out.println(subjectI);
            }

            jaxb.marshalling(specialities,SPEC_JAXB_XML);
            Specialities specialitiesUnmarshalled = jaxb.unmarshalling(Specialities.class,SPEC_JAXB_XML);
            for(Speciality specialityI : specialitiesUnmarshalled.getSpecialities())
            {
                System.out.println(specialityI);
            }

        } catch (ParseException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }



}
