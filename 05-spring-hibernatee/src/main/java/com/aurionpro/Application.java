package com.aurionpro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private StudentDao studentDao;

	public Application(StudentDao studentdao) {
		super();
		this.studentDao = studentdao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

//		addNewStudent();
//		findStudentById(10);
//		findAllStudents();
//		deleteStudentById();
//		findStudentByFirstName();
//		findStudentByFirstNameAndLastName();
//		findStudentByEmail();
//		updateStudent();
//		updateStudentById();

	}

//	private void updateStudentById() {
//		Student student= studentDao.updateStudentById(37);
////				student.setFirstName("rasika");
////				System.out.println(student);
//	}

	private void updateStudent() {
		Student student = new Student(37, "devika", "senapati", "bhavikaraj@gmail.com");
		studentDao.updateStudent(student);
	}

//	private void findStudentByEmail("rasika@gmail.com") {
////		String email="rahul@gmail.com";
//		List<Student> student = studentDao.findStudentByEmail(email);
//		System.out.println(student);
//	}
	private void findStudentByFirstNameAndLastName() {
		String lastName = "koli";
		String firstName = "jatinss";
		List<Student> students = studentDao.findStudentByFirstNameAndLastName(firstName, lastName);
		System.out.println(students);

	}

	private void findStudentByFirstName() {
		String firstName = "rahul";
//		studentDao.findStudentByFirstName(firstName);
		List<Student> students = studentDao.findStudentByFirstName(firstName);
		System.out.println(students);
	}

	private void deleteStudentById() {
		int id = 36;
		studentDao.deleteStudentById(id);

	}

	private void findAllStudents() {
		List<Student> students = studentDao.findAll();
		System.out.println(students);
	}

	private void findStudentById(int id) {
//		int id = 36;
		Student student = studentDao.findStudentById(id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student with " + id + "not found");
		}
	}

	private void addNewStudent() {
		Student student = new Student("Bhavika", "Rajput", "bhavikaraj@gmail.com");
		studentDao.saveStudent(student);
		System.out.println("Student Save Successfully");
	}

}
