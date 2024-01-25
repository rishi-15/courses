package com.courses.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.main.entities.Course;
import com.courses.main.repository.CourseRepository;

import com.courses.main.exception.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<Course> getCourses() {
		
		return courseRepository.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		
		Course course = courseRepository.findById(courseId).get();
		return course;
	}

	@Override
	public Course addCourse(Course course) {
		
		Course addedCourse =  courseRepository.save(course);
		return addedCourse;
	}

	@Override
	public Course updateCourse(Course course, long courseId) {
		
		Course fetchedCourse = courseRepository.findById(courseId).get();
		
		fetchedCourse.setTitle(course.getTitle());
		fetchedCourse.setDescription(course.getDescription());
		
		Course updatedCourse = courseRepository.save(fetchedCourse);
		
		return updatedCourse;
	}
	
	public void deleteCourse(long courseId) {
		courseRepository.findById(courseId).
				orElseThrow(() -> new ResourceNotFoundException("employee doesn't exist with id : " + courseId));
		
		courseRepository.deleteById(courseId);
	}

}
