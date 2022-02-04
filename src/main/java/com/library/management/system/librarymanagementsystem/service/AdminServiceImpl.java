package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.AdminModel;
import com.library.management.system.librarymanagementsystem.repository.AdminRepository;
import com.library.management.system.librarymanagementsystem.repository.IssuedBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminrepo;

    @Autowired
    private IssuedBookRepository issuedRepo;

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
        Optional<AdminModel> adminData= adminrepo.findById(admin_id);
        if(!adminData.isPresent()){
            System.out.println("Admin Not Found");
        }
        return adminData;
    }

    @Override
    public boolean deleteAdmin(long admin_id) {
        boolean flag = false;
        if (adminrepo.findById(admin_id).isPresent()) {
            //First delete Constraints 
            issuedRepo.deleteIssuedbookByAdmin(admin_id);
            adminrepo.deleteById(admin_id);
            if(!adminrepo.findById(admin_id).isPresent()){
                flag = true;
            }
           
        } else {
            System.out.println("Admin Not Found");
        }
        return flag;
    }

    @Override
    public Optional<AdminModel> searchAdmin(String admin_username) {

        return adminrepo.searchAdminUserName(admin_username);
    }

    @Override
    public boolean updateAdmin(String admin_username, String admin_role, long admin_id) {
        boolean flag = false;
        Optional<AdminModel> isAdminExits = adminrepo.findById(admin_id);
        if (isAdminExits.isPresent()) {
            adminrepo.updateAdminById(admin_username, admin_role, admin_id);
            flag = true;
        } else {
            System.out.println("Admin Not Found");
        }
        return flag;
    }

    @Override
    public boolean changeAdminPassword(String admin_password, long admin_id) {
        boolean flag = false;
        Optional<AdminModel> isAdminExits = adminrepo.findById(admin_id);
        if (isAdminExits.isPresent()) {
            adminrepo.changeAdminPassword(admin_password, admin_id);
            flag = true;
        } else {
            System.out.println("Admin Not Found");
        }
        return flag;
    }


}
