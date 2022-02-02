package com.library.management.system.librarymanagementsystem.controller;

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

    @GetMapping("/")
    public List<AdminModel> getAdmin() {
        return adminService.getAllAdmin();
    }

    @GetMapping("/{admin_id}")
    public Optional<AdminModel> getAdminById(@PathVariable("admin_id") Long admin_id) {
        return adminService.getAdminById(admin_id);
    }

    @PostMapping("/")
    public String addAdmin(@RequestBody AdminModel admin) {
        System.out.println(admin);
        return adminService.addAdmin(admin);
        // return admin;
    }

    @DeleteMapping("/{admin_id}")
    public boolean deleteAdmin(@PathVariable("admin_id") Integer admin_id) {
        return adminService.deleteAdmin(admin_id);
    }

    @PutMapping("/{admin_id}")
    public String updateAdmin(@PathVariable("admin_id") Integer admin_id) {
        return "update Admin " + admin_id;
    }

}
