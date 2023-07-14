package com.example.courseregistration.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseDto {
    @NotBlank(message = "Course Code is mandatory")
    String courseCode;
    String courseName;
    Boolean statusOpen;
}
