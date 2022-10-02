package db.parsers.sax;

import db.models.Speciality;
import db.models.Subject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubjectHandler extends DefaultHandler {
    private List<Subject> data;
    private Subject subject;
    private String currentElement = "";
    private StringBuilder currentText;

    public List<Subject> readDataFromXML(String filePath) throws ParserConfigurationException, SAXException, IOException {
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
            case "subjects":
                break;
            case "subject":
                subject = new Subject();
                data.add(subject);
                break;
            default:
                currentText = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("subject") || currentElement.equals("subjects")){
            return;
        }

        String content = currentText.toString();

        switch (currentElement) {
            case "id":
                subject.setId(Integer.parseInt(content));
                break;
            case "name":
                subject.setName(content);
                break;
            case "specialityId":
                subject.setSpecialityId(Integer.parseInt(content.trim()));
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