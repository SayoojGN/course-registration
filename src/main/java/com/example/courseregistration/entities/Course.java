package com.example.courseregistration.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Course {
    @Id
    String courseCode;
    String courseName;
    int numberOfStudents;
    Boolean statusOpen;
    List<Student> listOfStudents;
}
