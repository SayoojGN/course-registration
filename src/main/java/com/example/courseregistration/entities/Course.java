package com.example.courseregistration.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @Id
    String courseCode;
    String courseName;
    Long numberOfStudents;
    Boolean status;
}
