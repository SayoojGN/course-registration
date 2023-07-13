package com.example.courseregistration.repositories;

import com.example.courseregistration.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
