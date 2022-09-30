package db;

//Source https://www.tutorialspoint.com/xsd/xsd_validation.htm

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;




import javax.xml.transform.stream.StreamSource;


public class XMLValidator {
    private static final Logger LOGGER = LogManager.getLogger(XMLValidator.class);

    public static void main(String[] args) {

        LOGGER.info("specialities.xml validates against specialities.xsd? " + validateXML("src/main/resources/files/specialities.xsd", "src/main/resources/files/specialities.xml"));
        LOGGER.info("subjects.xml validates against subjects.xsd? " + validateXML("src/main/resources/files/subjects.xsd", "src/main/resources/files/subjects.xml"));
        LOGGER.info("exams.xml validates against exams.xsd? " + validateXML("src/main/resources/files/exams.xsd", "src/main/resources/files/exams.xml"));
    }

    public static boolean validateXML(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (Exception e) {
            LOGGER.error("Exception: " + e.getMessage());
            return false;
        } catch (Error e) {
            e.printStackTrace();
            LOGGER.error("Error: " + e.getMessage());
        }
        return true;
    }
}