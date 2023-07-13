package com.example.courseregistration.entities;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Student {
    @Id
    String studentRollNo;
    String studentName;
    String studentPassword;
    String studentEmail;
    String degree;
    int numOfCourses;
}
