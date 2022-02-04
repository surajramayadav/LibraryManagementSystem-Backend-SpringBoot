package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.UserModel;
import com.library.management.system.librarymanagementsystem.repository.IssuedBookRepository;
import com.library.management.system.librarymanagementsystem.repository.UserRepository;
import com.library.management.system.librarymanagementsystem.utils.CryptoGraphy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private IssuedBookRepository issuedRepo;

    @Override
    public boolean addUser(HashMap<String, String> user) {
        CryptoGraphy cryptoGraphy = new CryptoGraphy();
        boolean flag = false;
        String encryptedPassword = cryptoGraphy.setEncrpytedData(user.get("user_password"));
        // System.out.println(encryptedPassword);
        UserModel userModel = new UserModel();
        userModel.setUser_name(user.get("user_name"));
        userModel.setUser_phone(Long.parseLong(user.get("user_phone")));
        userModel.setUser_address(user.get("user_address"));
        userModel.setUser_password(encryptedPassword);
        if (userRepo.save(userModel) != null) {
            flag = true;
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
        if (!getUser.isPresent()) {
            System.out.println("User Not found");
        }
        return getUser;
    }

    @Override
    public boolean updateUser(String user_name, String user_phone, String user_address, long user_id) {
        boolean flag = false;
        Optional<UserModel> userData = userRepo.findById(user_id);
        if (userData.isPresent()) {
            userRepo.updateUserById(user_name, user_phone, user_address, user_id);
            flag = true;
        } else {
            System.out.println("User Not Found");
        }
        return flag;
    }

    @Override
    public boolean deleteUser(long user_id) {
        boolean flag = false;

        if (userRepo.findById(user_id).isPresent()) {
            // first delete Constarints
            issuedRepo.deleteIssuedbookByUser(user_id);
            userRepo.deleteById(user_id);
            if (!userRepo.findById(user_id).isPresent()) {
                flag = true;
            }
        } else {
            System.out.println("User Not Found");
        }
        return flag;
    }

    @Override
    public boolean changeUserPassword(String user_password, long user_id) {
        boolean flag = false;
        Optional<UserModel> userData = userRepo.findById(user_id);
        if (userData.isPresent()) {
            userRepo.changeUserPassword(user_password, user_id);
            flag = true;
        } else {
            System.out.println("User Not Found");
        }
        return flag;

    }

    @Override
    public Optional<UserModel> searchUser(String user_name) {
        return userRepo.searchUserName(user_name);
    }

    @Override
    public boolean loginUser(long user_phone, String user_password) {
        boolean flag = false;
        String encryptedPassword = userRepo.loginWithUserPhone(user_phone);
        if (encryptedPassword.length() != 0) {
            CryptoGraphy cryptoGraphy = new CryptoGraphy();
            String decryptedPassword = cryptoGraphy.getDecrpytedData(encryptedPassword);
            if (decryptedPassword.equals(user_password)) {
                flag = true;
            } else {
                System.out.println("User Phone Number And Password Invalid");
            }
        } else {
            System.out.println("User Phone Number And Password Invalid");
        }
        return flag;
    }

    @Override
    public boolean checkUserExits(long user_phone) {
        boolean flag=false;
        UserModel user=userRepo.checkUserExits(user_phone);
        if(user != null){
            flag=true;
        }
        return flag;
    }

}
