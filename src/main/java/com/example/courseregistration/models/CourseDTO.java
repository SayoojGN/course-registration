package com.example.courseregistration.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseDTO {
    @NotBlank(message = "Employee ID is mandatory")
    @Size(min = 3, max = 10, message = "Employee ID must be between 3 to 10 digits")
    String courseId;

    @NotBlank(message = "Employee ID is mandatory")
    @Size(min = 3, max = 10, message = "Employee ID must be between 3 to 10 digits")
    String courseName;
}
