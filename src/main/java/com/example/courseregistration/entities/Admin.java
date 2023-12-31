package com.example.courseregistration.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long adminId;
    String adminUserName;
    String adminPassword;
    String adminEmail;
}
