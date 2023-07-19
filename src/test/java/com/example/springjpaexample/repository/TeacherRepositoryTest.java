package com.example.springjpaexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		Course courseDba = Course.builder()
				.courseTitle("UML")
				.credit(5)
				.build();
		
		Course courseJava = Course.builder()
				.courseTitle("C++")
				.credit(6)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Hey Teacher")
				.lastName("Ho Teacher")
//				.courses(List.of(courseDba, courseJava))
				.build();
		
		teacherRepository.save(teacher);
	}

}
