package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.exception.ResourceNotFoundException;
import com.library.management.system.librarymanagementsystem.model.AdminModel;
import com.library.management.system.librarymanagementsystem.repository.AdminRepository;
import com.library.management.system.librarymanagementsystem.repository.IssuedBookRepository;
import com.library.management.system.librarymanagementsystem.utils.ApiResponse;
import com.library.management.system.librarymanagementsystem.utils.CryptoGraphy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    private  ApiResponse apiResponse=null;
    
    @Autowired
    private AdminRepository adminrepo;

    @Autowired
    private IssuedBookRepository issuedRepo;

    public AdminServiceImpl(){
         apiResponse=new ApiResponse();
    }

    @Override
    public HashMap<String,Boolean> addAdmin(HashMap<String,String> admin) {   
        boolean flag = false;
        CryptoGraphy cryptoGraphy = new CryptoGraphy();
        String encryptedPassword = cryptoGraphy.setEncrpytedData(admin.get("admin_password"));
        // System.out.println(encryptedPassword);
        AdminModel adminModel = new AdminModel();
        adminModel.setAdmin_username(admin.get("admin_username"));
        adminModel.setAdmin_role(admin.get("admin_role"));
        adminModel.setAdmin_password(encryptedPassword);
        
        if (adminrepo.save(adminModel) != null) {
            flag = true;
        }
        return apiResponse.addKeyValue(flag);

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
            throw new ResourceNotFoundException("Admin Not Found");
        }
        return adminData;
    }

    @Override
    public  HashMap<String,Boolean> deleteAdmin(long admin_id) {
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
            throw new ResourceNotFoundException("Admin Not Found");
        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public Optional<AdminModel> searchAdmin(String admin_username) {

        return adminrepo.searchAdminUserName(admin_username);
    }

    @Override
    public  HashMap<String,Boolean> updateAdmin(String admin_username, String admin_role, long admin_id) {
        boolean flag = false;
        Optional<AdminModel> isAdminExits = adminrepo.findById(admin_id);
        if (isAdminExits.isPresent()) {
            adminrepo.updateAdminById(admin_username, admin_role, admin_id);
            flag = true;
        } else {
            System.out.println("Admin Not Found");
            throw new ResourceNotFoundException("Admin Not Found");
        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public  HashMap<String,Boolean> changeAdminPassword(String admin_password, long admin_id) {
        boolean flag = false;
        CryptoGraphy cryptoGraphy = new CryptoGraphy();
        String encryptedPassword = cryptoGraphy.setEncrpytedData(admin_password);
        Optional<AdminModel> isAdminExits = adminrepo.findById(admin_id);
        if (isAdminExits.isPresent()) {
            adminrepo.changeAdminPassword(encryptedPassword, admin_id);
            flag = true;
        } else {
            System.out.println("Admin Not Found");
            throw new ResourceNotFoundException("Admin Not Found");
        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public  AdminModel loginAdmin(String admin_username, String admin_password) {
        // boolean flag = false;
        AdminModel admin;
        String encryptedPassword = adminrepo.loginWithAdmin(admin_username);
        if (encryptedPassword != null) {
            CryptoGraphy cryptoGraphy = new CryptoGraphy();
            String decryptedPassword = cryptoGraphy.getDecrpytedData(encryptedPassword);
            if (decryptedPassword.equals(admin_password)) {
                // flag = true;
                 admin=adminrepo.checkAdminIsExits(admin_username);
            } else {
                System.out.println("Username And Password Invalid");
                throw new ResourceNotFoundException("Username And Password Invalid");
            }
        } else {
            System.out.println("Username And Password Invalid");
            throw new ResourceNotFoundException("Username And Password Invalid");
        }
        return admin;
    }

    @Override
    public  HashMap<String,Boolean> checkAdminIsExits(String admin_username) {
       boolean flag=false;
       AdminModel admin=adminrepo.checkAdminIsExits(admin_username);
       if(admin != null){
           flag=true;
       }
       return apiResponse.addKeyValue(flag);
    }


}
