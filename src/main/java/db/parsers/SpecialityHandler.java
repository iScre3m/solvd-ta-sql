package db.parsers;

import db.models.Speciality;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SpecialityHandler extends DefaultHandler {
    private Speciality speciality;
    private StringBuilder element;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
        speciality = new Speciality();
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
            case "departmentId":
                element = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "id":
                speciality.setId(Integer.parseInt(element.toString()));
                break;
            case "name":
                speciality.setName(element.toString());
                break;
            case "departmentId":
                speciality.setDepartmentId(Integer.parseInt(element.toString()));
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

    public Speciality getSpeciality() {
        return this.speciality;
    }
}
