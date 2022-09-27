package db;

import db.parsers.SAXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ReadXMLWithSAX {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File("src/main/resources/files/subjects.xml"), saxHandler);
        }catch (Exception e){

        }


    }
}
