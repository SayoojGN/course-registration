package com.example.courseregistration.service.impl;

import com.example.courseregistration.entities.Admin;
import com.example.courseregistration.models.AdminDto;
import com.example.courseregistration.models.ResponseDTO;
import com.example.courseregistration.repositories.AdminRepository;
import com.example.courseregistration.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public ResponseDTO addAdmin(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .adminUserName(adminDto.getAdminUserName())
                .adminPassword(adminDto.getAdminPassword())
                .adminEmail(adminDto.getAdminEmail())
                .build();
        List<Admin> neededAdmin = getAdminByEmail(adminDto.getAdminEmail());
        if(neededAdmin.size() == 0) {
            adminRepository.save(admin);
            return new ResponseDTO(200, "Success", "Admin has been registered");
        } else {
            return new ResponseDTO(HttpStatus.FOUND.value(), "Exists", "These Admin details already exists");
        }
    }

    @Override
    public ResponseDTO deleteAdmin(String adminEmail) {
        List<Admin> adminList = getAdminByEmail(adminEmail);
        if(adminList.size() == 0) {
            return new ResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", "Admin does not exists");
        } else {
            adminRepository.delete(adminList.get(0));
            return new ResponseDTO(200, "Success", "Admin deleted successfully");
        }
    }

    @Override
    public ResponseDTO updateAdminPassword(String adminPassword, String adminEmail) {
        List<Admin> adminList = getAdminByEmail(adminEmail);
        if(adminList.size() == 0) {
            return new ResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", "Admin does not exists");
        } else {
            Admin admin = Admin.builder()
                    .adminUserName(adminList.get(0).getAdminUserName())
                    .adminPassword(adminPassword)
                    .adminEmail(adminList.get(0).getAdminEmail())
                    .build();
            adminRepository.delete(adminList.get(0));
            adminRepository.save(admin);
            return new ResponseDTO(200, "Success", "Admin Password updated successfully");
        }
    }

    @Override
    public ResponseDTO updateAdminUserName(String adminUserName, String adminEmail) {
        List<Admin> adminList = getAdminByEmail(adminEmail);
        if(adminList.size() == 0) {
            return new ResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", "Admin does not exists");
        } else {
            Admin admin = Admin.builder()
                    .adminUserName(adminUserName)
                    .adminPassword(adminList.get(0).getAdminPassword())
                    .adminEmail(adminList.get(0).getAdminEmail())
                    .build();
            adminRepository.delete(adminList.get(0));
            adminRepository.save(admin);
            return new ResponseDTO(200, "Success", "Admin User Name updated successfully");
        }
    }

    public List<Admin> getAdminByEmail(String adminEmail) {
        return adminRepository.findAll().stream()
                .filter(tempAdmin -> tempAdmin.getAdminEmail() == adminEmail)
                .toList();
    }
}
