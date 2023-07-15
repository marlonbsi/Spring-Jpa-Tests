package com.example.springjpaexample.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpaexample.entity.Guardian;
import com.example.springjpaexample.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("test@gmail.com")
				.firstName("TestName")
				.lastName("TestLastName")
//				.guardianEmail("testguardian@gmail.com")
//				.guardianMobile("919191")
//				.guardianName("GuardianName")
				.build();
				
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.name("Gname")
				.email("gemail@gmail.com")
				.mobile("939393")
				.build();
		
		Student student = Student.builder()
				.firstName("StudentG")
				.lastName("LastNameG")
				.emailId("withguardian@gmail.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudents() {
		List <Student> studentsList = studentRepository.findAll();
		System.out.println("studentsList: " + studentsList);
	}
	
	@Test
	public void printStudentsByFirstName() {
		List <Student> studentsList = studentRepository.findByFirstName("StudentG");
		System.out.println("studentList: " + studentsList);
	}
	
	@Test
	public void printStudentsByFirstNameContaining() {
		List <Student> studentsList = studentRepository.findByFirstNameContaining("st");
		System.out.println("studentList: " + studentsList);
	}
	
	@Test
	public void printStudentBasedOnGurdianName() {
		List<Student> studentsList = studentRepository.findByGuardianName("Gname");
		System.out.println("studentsList: " + studentsList);
	}
	
	@Test
	public void printStudentBasedOnFirstNameAndLastName() {
		Student student = studentRepository.findByFirstNameAndLastName("StudentG", "LastNameG");
		System.out.println("Student: " + student);
	}
	
	@Test
	public void printGetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("test@gmail.com");
		System.out.println("Student: " + student);
	}
	
	@Test
	public void printGetStudentFirstNameByEmailAddress() {
		String studentName = studentRepository.getStudentFirstNameByEmailAddress("test@gmail.com");
		System.out.println("Student: " + studentName);
	}
	
	@Test
	public void printGetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("test@gmail.com");
		System.out.println("Student: " + student);
	}
	
	@Test
	public void printGetStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("test@gmail.com");
		System.out.println("Student: " + student);
	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("Fulano Updated", "test@gmail.com");
	}

}
