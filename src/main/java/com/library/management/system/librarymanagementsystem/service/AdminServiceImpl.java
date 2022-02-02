package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.AdminModel;
import com.library.management.system.librarymanagementsystem.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminrepo;

    @Override
    public String addAdmin(AdminModel admin) {
        try {
            System.out.println(admin);
            adminrepo.save(admin);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "added";
    }

    @Override
    public List<AdminModel> getAllAdmin() {
        return adminrepo.findAll();
    }

    @Override
    public Optional<AdminModel> getAdminById(long admin_id) {
        return adminrepo.findById(admin_id);
    }

    @Override
    public boolean updateAdmin(long admin_id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteAdmin(long admin_id) {
        boolean flag = false;
        adminrepo.deleteById(admin_id);
        if (!adminrepo.findById(admin_id).isPresent()) {
            flag = true;
        }
        return flag;
    }
}
