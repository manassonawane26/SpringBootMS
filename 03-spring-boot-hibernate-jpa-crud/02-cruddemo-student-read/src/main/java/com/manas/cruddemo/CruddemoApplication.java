package com.manas.cruddemo;

import com.manas.cruddemo.dao.StudentDAO;
import com.manas.cruddemo.dao.StudentDAOImpl;
import com.manas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.JavaBean;

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
		};
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