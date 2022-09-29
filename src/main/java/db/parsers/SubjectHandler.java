package db.parsers;

import db.models.Subject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SubjectHandler extends DefaultHandler {
    private Subject subject;

    private StringBuilder element;


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
        subject = new Subject();
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
                subject.setId(Integer.parseInt(element.toString()));
                break;
            case "name":
                subject.setName(element.toString());
                break;
            case "specialityId":
                subject.setSpecialityId(Integer.parseInt(element.toString()));
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

    public Subject getSubject() {
        return this.subject;
    }
}