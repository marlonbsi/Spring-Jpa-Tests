package com.example.springjpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpaexample.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
