package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.AdminModel;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    
    public String addAdmin(AdminModel admin);
    public List<AdminModel> getAllAdmin();
    public Optional<AdminModel> getAdminById(long admin_id);
    public boolean deleteAdmin(long admin_id);
    public Optional<AdminModel> searchAdmin(String admin_username);
    public boolean updateAdmin(String admin_username,String admin_role,long admin_id);
    public boolean changeAdminPassword(String admin_password,long admin_id);
    
}
