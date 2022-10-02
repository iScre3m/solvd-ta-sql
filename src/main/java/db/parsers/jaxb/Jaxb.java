package db.parsers.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {
    public void marshalling(Object object, String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File(filePath);
        marshaller.marshal(object, file);
    }

    public <T> T unmarshalling(Class<T> c, String filePath) throws JAXBException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JAXBContext jaxbContext = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new File(filePath));


//        for(Exam exam : exams.getExams())
//        {
//            System.out.println(exam.getId());
//            System.out.println(simpleDateFormat.format(exam.getDate()));
//            System.out.println(exam.getCourseId());
//            System.out.println(exam.getSubjectId());
//            System.out.println("-----------");
//        }
    }
}
