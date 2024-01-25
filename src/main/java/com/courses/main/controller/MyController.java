package com.courses.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.main.exception.ResourceNotFoundException;

import com.courses.main.entities.Course;
import com.courses.main.services.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application";
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		
		List<Course> courses =  courseService.getCourses();
		return ResponseEntity.ok(courses);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable long courseId) {
		
		Course course =  courseService.getCourse(courseId);
		
		return ResponseEntity.ok(course);
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		Course addedCourse = courseService.addCourse(course);
		return addedCourse;
	}
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable long courseId) {
		
		Course updatedCourse = courseService.updateCourse(course, courseId);
		return updatedCourse;
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId) {
		
		try {
			
			this.courseService.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
