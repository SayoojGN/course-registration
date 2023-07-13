package com.example.courseregistration.repositories;

import com.example.courseregistration.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
