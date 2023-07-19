package com.example.springjpaexample.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.Student;
import com.example.springjpaexample.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses: " +courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("CT Name")
				.lastName("CT LastName")
				.build();
		
		Course course = Course.builder()
				.courseTitle("APO")
				.credit(5)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
	
	@Test
	public void finadAllPagination() {
		Pageable firstPageWithThreeRecords = 
				PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = 
				PageRequest.of(1, 2);
		List<Course> courses = 
				courseRepository.findAll(secondPageWithTwoRecords).getContent();
		
		Long totalElements = 
				courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		
		Long totalPages = 
				(long) courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		
		System.out.println("totalPages: " + totalPages);
		System.out.println("totalElements: " + totalElements);
		System.out.println("courses: " + courses);
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = 
				PageRequest.of(0, 2, Sort.by("courseTitle"));
		Pageable sortByCreditDesc = 
				PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = 
				PageRequest.of(
						0, 2, Sort.by("courseTitle").descending()
						.and(Sort.by("credit"))
						);
		List<Course> courses = 
				courseRepository.findAll(sortByTitle).getContent();
		System.out.println("courses: " + courses);
	}
	
	@Test
	public void printfindByCourseTitleContaining() {
		Pageable firstPageTenRecords = 
				PageRequest.of(0, 10);
		List<Course> courses = 
				courseRepository.findByCourseTitleContaining(
						"D", firstPageTenRecords).getContent();
		
		System.out.println("courses: " + courses);
	}
	
	@Test
	public void saveCourseWithTeacherAndStudent() {
		Teacher teacher = Teacher.builder()
				.firstName("TName")
				.lastName("TLName")
				.build();
		
		Student student = Student.builder()
				.firstName("Fulano")
				.lastName("Silva")
				.emailId("stu2@gmail.com")
				.build();
		
		Course course = Course.builder()
				.courseTitle("AI")
				.credit(4)
				.teacher(teacher)
				.build();
		
		course.addStudents(student);
		
		courseRepository.save(course);
	}
	
	
}
