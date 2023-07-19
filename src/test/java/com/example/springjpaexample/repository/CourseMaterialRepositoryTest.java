package com.example.springjpaexample.repository;

import java.util.List;

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
				.courseTitle(".NET")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.alturl.com;")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() {
		
		List<CourseMaterial> courseMaterials = repository.findAll();
		System.out.println("courseMaterials: " +courseMaterials);
		
	}
	
}
