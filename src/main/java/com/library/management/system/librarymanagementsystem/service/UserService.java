package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.UserModel;

import org.springframework.stereotype.Service;
@Service
public interface UserService {
    public boolean addUser(UserModel user);
    public List<UserModel> getAllUser();
    public Optional<UserModel> getUserById(long user_id);
    public boolean updateUser(long user_id);
    public boolean deleteUser(long user_id);

}
