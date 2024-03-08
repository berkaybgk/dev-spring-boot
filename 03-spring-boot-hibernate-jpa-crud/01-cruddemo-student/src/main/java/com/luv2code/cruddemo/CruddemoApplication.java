package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;
import java.util.SplittableRandom;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students..");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println(rowsDeleted + " rows are deleted.");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int theId = 5;
		System.out.println("Deleting the student with the id of: " + theId);
		studentDAO.delete(theId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the student based on id
		int theId = 4;
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Student has been found with the id of: " + theId);

		// change the email
		myStudent.setEmail(myStudent.getFirstName().toLowerCase() + "@gmail.com");
		System.out.println("email address has been updated");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Here is the recent info of the student:");
		System.out.println(studentDAO.findById(theId));

	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Gök");

		// display them
		theStudents.forEach(System.out::println);

	}



	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> studentsList = studentDAO.findAll();

		// display the list of students
		studentsList.forEach(System.out::println);

	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a student..");
		Student tempStudent = new Student("Berkay","Gök","berkay@gmail.com");

		// save the student
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		// display if of the saved student
		System.out.println("ID of the saved student is: " + tempStudent.getId());

		// retrieve student based on id: primary key
		System.out.println("Retrieving student..");
		Student foundStudent = studentDAO.findById(tempStudent.getId());

		// display student
		if (foundStudent != null)
			System.out.println("Student has been found! Here is the info: ");
		System.out.println(foundStudent);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDao){
		Student tempStudent1 = new Student("John", "Marshall", "jm@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com");
		System.out.println("Save multiple students...");
		List<Student> students =List.of(tempStudent1,tempStudent2,tempStudent3);
		students.forEach(studentDao::save);
	}



}
