package db.parsers.sax;

import db.models.Exam;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ExamHandler extends DefaultHandler {


    private List<Exam> data;
    private Exam exam;
    private String currentElement = "";
    private StringBuilder currentText;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<Exam> readDataFromXML(String filePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filePath), this);
        return data;
    }


    @Override
    public void startDocument() {
        data = new ArrayList<>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        switch (currentElement) {
            case "exams":
                break;
            case "exam":
                exam = new Exam();
                data.add(exam);
                break;
            default:
                currentText = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("exam") || currentElement.equals("exams")){
            return;
        }

        String content = currentText.toString();

        switch (currentElement) {
            case "id":
                exam.setId(Integer.parseInt(content));
                break;
            case "date":
                try {
                    exam.setDate(dateFormat.parse(content));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "courseId":
                exam.setCourseId(Integer.parseInt(content));
                break;
            case "subjectId":
                exam.setSubjectId(Integer.parseInt(content.trim()));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentText != null) {
            currentText.append(ch, start, length);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("End document");
    }
}