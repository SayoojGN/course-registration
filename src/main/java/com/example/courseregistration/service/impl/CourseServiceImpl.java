package com.example.courseregistration.service.impl;

import com.example.courseregistration.repositories.CourseRepository;
import com.example.courseregistration.service.CourseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
}
