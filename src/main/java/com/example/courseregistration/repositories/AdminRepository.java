package com.example.courseregistration.repositories;

import com.example.courseregistration.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
