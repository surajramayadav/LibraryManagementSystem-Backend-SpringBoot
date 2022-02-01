package com.library.management.system.librarymanagementsystem.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {
    
    @GetMapping("/")
    public String getUser() {
        return "Get user";
    }

    @GetMapping("/{user_id}")
    public String getUserById(@PathVariable("user_id") Integer user_id){
        return "Get user Id"+user_id;
    }

    @PostMapping("/")
    public String addUser(){
        return "Add user";
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable("user_id") Integer user_id){
        return "delete user " +user_id;
    }

    @PutMapping("/{user_id}")
    public String updateUser(@PathVariable("user_id") Integer user_id){
        return "update user " +user_id;
    }
}
