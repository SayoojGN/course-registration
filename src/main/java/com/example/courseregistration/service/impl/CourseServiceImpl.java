package com.example.courseregistration.service.impl;

import com.example.courseregistration.entities.Course;
import com.example.courseregistration.models.CourseDto;
import com.example.courseregistration.models.ResponseDTO;
import com.example.courseregistration.repositories.CourseRepository;
import com.example.courseregistration.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public ResponseDTO addCourse(CourseDto courseDto) {
        Course course = Course.builder()
                .courseCode(courseDto.getCourseCode())
                .courseName(courseDto.getCourseName())
                .statusOpen(Boolean.TRUE)
                .numberOfStudents(0)
                .listOfStudents(new ArrayList<>())
                .build();
        Optional<Course> optionalCourse = courseRepository.findById(courseDto.getCourseCode());
        if(optionalCourse.isEmpty()) {
            courseRepository.save(course);
            return new ResponseDTO(200, "Success", "Course added successfully");
        } else {
            return new ResponseDTO(HttpStatus.FOUND.value(), "Already Present", "Course already present");
        }
    }

    public ResponseDTO updateCourse(CourseDto courseDto) {
        Course course = Course.builder()
                .courseCode(courseDto.getCourseCode())
                .courseName(courseDto.getCourseName())
                .statusOpen(courseDto.getStatusOpen())
                .build();
        Optional<Course> optionalCourse = courseRepository.findById(courseDto.getCourseCode());
        if(optionalCourse.isPresent()) {
            courseRepository.deleteById(course.getCourseCode());
            courseRepository.save(optionalCourse.get());
            return new ResponseDTO(200, "Success", "Course updated successfully");
        } else {
            return new ResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", "Course does not exist");
        }
    }

    public ResponseDTO deleteCourse(String courseCode) {
        Optional<Course> optionalCourse = courseRepository.findById(courseCode);
        if(optionalCourse.isPresent()) {
            courseRepository.deleteById(courseCode);
            return new ResponseDTO(200, "Success", "Course deleted successfully");
        } else {
            return new ResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", "Course does not exist");
        }
    }
}
