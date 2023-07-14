package com.example.courseregistration.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminDto {
    @NotBlank(message = "Admin User Name is mandatory")
    String adminUserName;
    @NotBlank(message = "Admin Password is mandatory")
    String adminPassword;
    @NotBlank(message = "Admin Email is mandatory")
    String adminEmail;
}
