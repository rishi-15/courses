package com.courses.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courses.main.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
