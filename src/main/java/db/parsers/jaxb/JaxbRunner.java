package db.parsers.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JaxbRunner {
     private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
     private static String EXAM_JASB_XML = "src/main/resources/files/examsjaxb.xml";

    public static void main(String[] args) {
        try{

            Exams exams = new Exams();
            exams.setExams(new ArrayList<Exam>());

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

            //marshalling(exams);
            unmarshalling();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void marshalling(Exams exams) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Exams.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File(EXAM_JASB_XML);
        marshaller.marshal(exams, file);
    }

    public static void unmarshalling() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Exams.class);
        Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();

        Exams exams = (Exams) jaxbUnmarshall.unmarshal(new File(EXAM_JASB_XML));

        for(Exam exam : exams.getExams())
        {
            System.out.println(exam.getId());
            System.out.println(simpleDateFormat.format(exam.getDate()));
            System.out.println(exam.getCourseId());
            System.out.println(exam.getSubjectId());
            System.out.println("-----------");
        }
    }
}
