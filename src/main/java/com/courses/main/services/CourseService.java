package com.courses.main.services;

import java.util.List;

import com.courses.main.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course, long courseId);
	public void deleteCourse(long courseId);
}
