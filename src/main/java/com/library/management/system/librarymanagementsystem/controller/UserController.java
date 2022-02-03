package com.library.management.system.librarymanagementsystem.controller;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.UserModel;
import com.library.management.system.librarymanagementsystem.service.UserService;

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
@RequestMapping(path="/api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserModel> getUser() {
        return  userService.getAllUser();
    }

    @GetMapping("/{user_id}")
    public Optional<UserModel> getUserById(@PathVariable("user_id") Integer user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping("/")
    public boolean addUser(@RequestBody UserModel user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{user_id}")
    public boolean deleteUser(@PathVariable("user_id") Integer user_id){
        return userService.deleteUser(user_id);
    }

    @PutMapping("/{user_id}")
    public String updateUser(@PathVariable("user_id") Integer user_id){
        return "update user " +user_id;
    }
}
