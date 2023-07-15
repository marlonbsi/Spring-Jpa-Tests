package com.example.springjpaexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springjpaexample.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String name);
	List<Student> findByLastNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	//JPQL
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	
	//Native query
	@Query(
			value = "select * from tb_student s where s.email_address = ?1",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNative(String emailId);
	
	//Native query
	@Query(
			value = "select * from tb_student s where s.email_address = :emailId",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
	//Update data based on object data
	@Modifying
	@Transactional
	@Query(
			value = "update tb_student s set s.first_name = :firstName where s.email_address = :emailId",
			nativeQuery = true
	)
	int updateStudentNameByEmailId(
			@Param("firstName") String firstName, 
			@Param("emailId") String emailId
	);
	
	
	
	
	
}
