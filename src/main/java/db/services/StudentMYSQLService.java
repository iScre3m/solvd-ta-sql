package db.services;

import db.dao.ClassDAO;
import db.dao.CourseDAO;
import db.dao.StudentDAO;
import db.models.Course;
import db.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentMYSQLService {
    StudentDAO studentDAO;
    CourseDAO courseDAO;
    ClassDAO classDAO;

    public Student getStudentById(int id) throws SQLException {
        Student student = studentDAO.getById(id);
        //List<Course> courses = courseDAO.getById(id);
        return student;
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
		List<Passenger> passengers = passengerDAO.readById(id);
		plain.setPassengers(passengers);
		Pilot pilot = pilotDAO.readById(id);
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
