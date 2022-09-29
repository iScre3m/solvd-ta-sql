package db.parsers;

import db.models.Exam;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ExamHandler extends DefaultHandler {
    private Exam exam;

    private StringBuilder element;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
        exam = new Exam();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "id":
            case "name":
            case "specialityId":
                element = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "id":
                exam.setId(Integer.parseInt(element.toString()));
                break;
            case "date":
                try {
                    exam.setDate(dateFormat.parse(element.toString()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "courseId":
                exam.setCourseId(Integer.parseInt(element.toString()));
                break;
            case "subjectId":
                exam.setSubjectId(Integer.parseInt(element.toString()));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element == null) {
            element = new StringBuilder();
        } else {
            element.append(ch, start, length);
        }
    }

    public Exam getSubject() {
        return this.exam;
    }
}