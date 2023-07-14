package com.example.courseregistration.service;

import com.example.courseregistration.models.AdminDto;
import com.example.courseregistration.models.ResponseDTO;

public interface AdminService {
    ResponseDTO addAdmin(AdminDto adminDto);

    ResponseDTO deleteAdmin(String adminEmail);

    ResponseDTO updateAdminPassword(String adminPassword, String adminEmail);

    ResponseDTO updateAdminUserName(String adminUserName, String adminEmail);
}
