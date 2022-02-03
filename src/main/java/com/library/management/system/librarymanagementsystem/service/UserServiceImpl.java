package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.UserModel;
import com.library.management.system.librarymanagementsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean addUser(UserModel user) {
        boolean flag = false;
        try {
            if (userRepo.save(user) != null) {
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return flag;

    }

    @Override
    public List<UserModel> getAllUser() {

        return userRepo.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(long user_id) {
        Optional<UserModel> getUser = userRepo.findById(user_id);
        return getUser;
    }

    @Override
    public boolean updateUser(long user_id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser(long user_id) {
        boolean flag = false;
        userRepo.deleteById(user_id);
        if(!userRepo.findById(user_id).isPresent()){
            flag =true;
        }
        return flag;
    }

}
