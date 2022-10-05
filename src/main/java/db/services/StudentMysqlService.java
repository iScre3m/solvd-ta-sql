package db.services;

import db.dao.ClassDAO;
import db.dao.CourseDAO;
import db.dao.StudentDAO;
import db.models.Class;
import db.models.Course;
import db.models.Student;
import java.sql.SQLException;
import java.util.List;

public class StudentMysqlService {

    private StudentDAO studentDAO = new StudentDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private ClassDAO classDAO = new ClassDAO();


    public Student getById(int id) throws SQLException {
        Student student = studentDAO.getById(id);

        List<Course> courses = courseDAO.getByStudentId(id);
        student.setCourses(courses);

        List<Class> classes = classDAO.getByStudentId(id);
        student.setClasses(classes);

        return student;
    }

    public void delete(int id) throws SQLException {
        studentDAO.delete(id);
    }

    public void insert(Student student) throws SQLException {
        studentDAO.insert(student);
    }

    public void update(Student student) throws SQLException {
        studentDAO.update(student);
    }

    public List<Student> getAll() throws SQLException {
        return studentDAO.getAll();
    }

    /* Example
class PassengerMySQLDAO implements IDAO{

    public Passenger readByPlainId(int plainId){
    List<Passenger> passengers = new ArrayList<Passenger>();

    populate plain with query

    return passengers;
	}
}


class PlainMySQLService(){

	PlainMySQLDAO plainDAO;
	PassengerMySQLDAO passengerDAO;
	PilotMySQLDAO pilotDAO;


	public Plain getPlainById(int id){
		Plain plain = plainDAO.readById(id);
		List<Passenger> passengers = passengerDAO.readByPlainId(id); create readByPlainId function in passengerDAO
		plain.setPassengers(passengers);
		Pilot pilot = pilotDAO.readByPlainId(id);
		plain.setPilot(pilot);
		return plain;
	}

	public void insertPlain(Plain plain){

		plainDao.insert(plain);
		plain.getPassengers().forEach(p -> (passengerDAO.insert(p); ));
	}

}

     */
}
