package com.library.management.system.librarymanagementsystem.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/admin")
public class AdminController {

    @GetMapping("/")
    public String getAdmin() {
        return "Get Admin";
    }

    @GetMapping("/{admin_id}")
    public String getAdminById(@PathVariable("admin_id") Integer admin_id){
        return "Get Admin Id"+admin_id;
    }

    @PostMapping("/")
    public String addAdmin(){
        return "Add Admin";
    }

    @DeleteMapping("/{admin_id}")
    public String deleteAdmin(@PathVariable("admin_id") Integer admin_id){
        return "delete Admin " +admin_id;
    }

    @PutMapping("/{admin_id}")
    public String updateAdmin(@PathVariable("admin_id") Integer admin_id){
        return "update Admin " +admin_id;
    }


}
