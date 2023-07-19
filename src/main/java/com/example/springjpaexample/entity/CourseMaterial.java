package com.example.springjpaexample.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
			name = "course_material_sequence",
			sequenceName = "course_material_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_material_sequence"
	)
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			//Allows the insert for the dependencies as well
			fetch = FetchType.LAZY,
			optional = false
			//Whenever you try to save a Course, a CourseMaterial is required
	)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
	)
	private Course course;

}
