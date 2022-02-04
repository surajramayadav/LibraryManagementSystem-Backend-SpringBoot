package com.library.management.system.librarymanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.AdminModel;
import com.library.management.system.librarymanagementsystem.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get All admin
    @GetMapping("/")
    public List<AdminModel> getAdmin() {
        return adminService.getAllAdmin();
    }

    // get admin by id
    @GetMapping("/{admin_id}")
    public Optional<AdminModel> getAdminById(@PathVariable("admin_id") Long admin_id) {
        return adminService.getAdminById(admin_id);
    }

    // search admin by name
    @GetMapping("/search/{admin_username}")
    public Optional<AdminModel> getAdminById(@PathVariable("admin_username") String admin_username) {
        return adminService.searchAdmin(admin_username);
    }

    // checking admin is already exits or not
    @GetMapping("/exits/{admin_username}")
    public boolean checkAdminIsExits(@PathVariable("admin_username") String admin_username) {
        return adminService.checkAdminIsExits(admin_username);
    }

    // register admin
    @PostMapping("/")
    public boolean addAdmin(@RequestBody HashMap<String,String> admin) {
        // System.out.println(admin);
        return adminService.addAdmin(admin);
    
    }

    // singup admin
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody HashMap<String,String> admin) {
        // System.out.println(admin);
        return adminService.loginAdmin(admin.get("admin_username"), admin.get("admin_password"));
    
    }

    // delete admin
    @DeleteMapping("/{admin_id}")
    public boolean deleteAdmin(@PathVariable("admin_id") Integer admin_id) {
        return adminService.deleteAdmin(admin_id);
    }

    // update admin

    @PutMapping("/{admin_id}")
    public boolean updateAdmin(@PathVariable("admin_id") Long admin_id,@RequestBody HashMap<String,String> updateData) {
        return adminService.updateAdmin(updateData.get("admin_username"), updateData.get("admin_role"), admin_id);
    }

    // change password
    @PutMapping("/password/{admin_id}")
    public boolean changeAdminPassword(@PathVariable("admin_id") Long admin_id,@RequestBody HashMap<String,String> updatepassword) {
        return adminService.changeAdminPassword(updatepassword.get("admin_password"), admin_id);
    }

    

}
