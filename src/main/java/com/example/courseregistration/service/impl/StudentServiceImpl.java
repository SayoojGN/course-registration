package com.example.courseregistration.service.impl;

import com.example.courseregistration.repositories.StudentRepository;
import com.example.courseregistration.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
}
