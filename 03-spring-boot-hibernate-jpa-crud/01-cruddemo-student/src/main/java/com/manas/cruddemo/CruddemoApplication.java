package com.manas.cruddemo;

import com.manas.cruddemo.dao.StudentDAO;
import com.manas.cruddemo.dao.StudentDAOImpl;
import com.manas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.JavaBean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// this is to create command line application (CommandLineRunner is from spring boot framework)
	@Bean
	public CommandLineRunner  commandLineRunner(StudentDAOImpl studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAOImpl studentDAO) {
		System.out.println("Deleting all Students");
		int numrowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numrowsDeleted);
	}

	private void deleteStudent(StudentDAOImpl studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAOImpl studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 4;
		System.out.println("Getting student with Id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Raghav", "Ram"
		System.out.println("Updating Student ...");
		myStudent.setFirstName("Ram");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAOImpl studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Raghuwanshi");

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAOImpl studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAOImpl studentDAO) {

		// craete a stud obj
		System.out.println("Creating new Student object");
		Student tempStudent = new Student("Ram", "Raghuwanshi", "ram@ayodhya.com");

		// save the stud obj
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		// display id of the saved stud
		int theId =  tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAOImpl studentDAO) {
		System.out.println("Creating 3 new Student object");
		Student tempStudent1 = new Student("Lakshman", "Raghuwanshi", "lakshman@ayodhya.com");
		Student tempStudent2 = new Student("Bharat", "Raghuwanshi", "bharat@ayodhya.com");
		Student tempStudent3 = new Student("Shatrughn", "Raghuwanshi", "shatrughn@ayodhya.com");

		System.out.println("Saving the students... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAOImpl studentDAO) {
		// create the student obj
		System.out.println("Creating new Student object");
		Student tempStudent = new Student("Ram", "Raghuwanshi", "ram@ayodhya.com");

		// save the stud obj
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		// display id of the saved stud
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}

}