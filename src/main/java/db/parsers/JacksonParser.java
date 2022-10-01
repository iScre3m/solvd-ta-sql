package db.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;

public class JacksonParser {
    static Logger LOGGER = LogManager.getLogger(JacksonParser.class.getName());

    public <T> T marshall(String path, Class<?> T) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return (T) objectMapper.readValue(new FileReader(path), T);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return (T) T;
        }
    }

    public String unmarshal(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to unmarshal");
            LOGGER.error( e.getMessage(), e);
        }
        return json;
    }


}
