package com.example.cruddemo;

import com.example.cruddemo.DAO.StudentDAO;
import com.example.cruddemo.entity.Student;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
			createMulipleStudents(studentDAO);
			//readStudent(studentDAO);
			//QueryForStudents(studentDAO);
			//QueryForStudentsBylastName(studentDAO) ;
			//updateStudent(studentDAO) ;
			//deleteStudent(studentDAO) ;
			//deleteAllStudents(studentDAO) ;

        };
    }

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students .............");
		int numberOfDeleted = studentDAO.deleteAll() ;
		System.out.println("Number of Students deleted are " + numberOfDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 2 ;
		System.out.println("Deleting student with id :" + studentID );
		studentDAO.Delete(studentID);

	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve the student based on id :primary key
		int studentId = 1 ;
		System.out.println("Getting student with id : " + studentId);
		Student theStudent = studentDAO.findByID(studentId) ;

		//change first name to "New"
		System.out.println("Updating student ............");
		theStudent.setFirstName("mo2men");

		//update the student
		studentDAO.Update(theStudent);

		//Display after update
		System.out.println("Updated Student : " + theStudent);

	}

	private void QueryForStudentsBylastName(StudentDAO studentDAO) {

		List<Student> lastnameOfStudents = studentDAO.findByLastName("tarek");
		for (Student students:
			 lastnameOfStudents) {
			System.out.println(students);
		}

	}

	private void QueryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new Student object .........");
		Student tempStudent = new Student("ali", "mohamed", "alimohamed@gmail.com");

		// save the student object
		System.out.println("Saving the student.........");
		studentDAO.save(tempStudent);

		// display id of thd saved student
		int theId = tempStudent.getId() ;
		System.out.println("Saved student, Generated id: " + theId);

		//Read From dataBase the students based on id
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findByID(theId) ;


		//display student
		System.out.println("Found the student " + myStudent);

	}

	private void createMulipleStudents(StudentDAO studentDAO) {
		// create multiple of students object
		System.out.println("Creating new 3 Student objects .........");
		Student tempStudent1 = new Student("mo2men", "hatem", "mo2men@gmail.com");
		Student tempStudent2 = new Student("ahmed", "tarek", "tarek@gmail.com");
		Student tempStudent3 = new Student("youssef", "ayoub", "ayoub@gmail.com");
		// save the students object

		System.out.println("Saving the student.........");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



		//display ids of the students
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());


	}


	private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new Student object .........");
        Student tempStudent = new Student("Ahmed", "el sayed", "manahmed247@gmail.com");

        // save the student object
		System.out.println("Saving the student.........");
        studentDAO.save(tempStudent);

        //display id of the student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }


}
