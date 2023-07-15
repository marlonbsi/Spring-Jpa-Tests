package com.example.springjpaexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.courseTitle("DSA")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google.com;")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}
	
}
