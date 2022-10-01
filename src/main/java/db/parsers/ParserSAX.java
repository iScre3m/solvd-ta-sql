package db.parsers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ParserSAX {
    static Logger LOGGER = LogManager.getLogger(ParserSAX.class.getName());

    public <T extends DefaultHandler> T parse(String path, T handler) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            assert saxParser != null;
            saxParser.parse(path, handler);
        } catch (SAXException | IOException e) {
            LOGGER.error(e.getMessage());
        }
        return handler;
    }

}
