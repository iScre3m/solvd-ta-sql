package db.parsers.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.models.Exam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JacksonParser {
    static Logger LOGGER = LogManager.getLogger(JacksonParser.class.getName());
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String JSON_EXAM = "src/main/resources/files/exam.json";
    private static final String JSON_EXAMSCREATED = "src/main/resources/files/examscreated.json";

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("1. Serialize simple object");
        System.out.println("2. Deserialize simple object");
        System.out.println("3. Serialize object list");
        System.out.println("4. Deserialize object list");
        option = Integer.parseInt(sc.nextLine());

        switch (option){
            case 1: serializeSimpleObject();
            break;
            case 2: deserializeSimpleObject();
            break;
            case 3: serializeObjectList();
            break;
            case 4: deserializeObjectList();
            break;
            default:
                System.out.println("Wrong option type a correct option");
                main(new String[0]);
        }
    }

    public static void serializeSimpleObject() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Exam exam = new Exam(1,simpleDateFormat.parse("2022-10-14"),1,8);
        objectMapper.writeValue(new File(JSON_EXAM),exam);
    }

    public static void deserializeSimpleObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Exam exam = objectMapper.readValue(new File(JSON_EXAM), Exam.class);
        System.out.println(exam);
    }

    public static void serializeObjectList() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Exam> exams = new ArrayList<>();
        Exam exam = new Exam(1,simpleDateFormat.parse("2022-10-14"),1,8);
        Exam exam2 = new Exam(2,simpleDateFormat.parse("2022-10-15"),2,8);
        exams.add(exam);
        exams.add(exam2);

        objectMapper.writeValue(new File(JSON_EXAMSCREATED),exams);
    }

    public static void deserializeObjectList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Exam> exams = objectMapper.readValue(new File(JSON_EXAMSCREATED), new TypeReference<>(){});
        exams.forEach(System.out::println);
    }


}
