package db.parsers.sax;

import db.models.Speciality;
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

public class SpecialityHandler extends DefaultHandler {
    private List<Speciality> data;
    private Speciality speciality;
    private String currentElement = "";
    private StringBuilder currentText;

    public List<Speciality> readDataFromXML(String filePath) throws ParserConfigurationException, SAXException, IOException {
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
            case "specialities":
                break;
            case "speciality":
                speciality = new Speciality();
                data.add(speciality);
                break;
            default:
                currentText = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("speciality") || currentElement.equals("specialities")){
            return;
        }

        String content = currentText.toString();

        switch (currentElement) {
            case "id":
                speciality.setId(Integer.parseInt(content));
                break;
            case "name":
                speciality.setName(content);
                break;
            case "departmentId":
                speciality.setDepartmentId(Integer.parseInt(content.trim()));
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
