package com.example.courseregistration.service.impl;

import com.example.courseregistration.repositories.AdminRepository;
import com.example.courseregistration.service.AdminService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
}
