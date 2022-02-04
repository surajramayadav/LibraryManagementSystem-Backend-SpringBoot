package com.library.management.system.librarymanagementsystem.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.library.management.system.librarymanagementsystem.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    
    @Query(value = "SELECT * FROM user res where res.user_id = ?1", nativeQuery = true)
    public UserModel getUser(Long user_id);

    @Query(value ="SELECT * FROM user res where res.user_name like ?1%", nativeQuery = true)
    public Optional<UserModel>  searchUserName(String user_name);

    @Transactional
    @Modifying
    @Query(value ="update user a set a.user_name = ?1,a.user_phone = ?2,a.user_address = ?3 where a.user_id = ?4", nativeQuery = true)
     void updateUserById(String user_name,String user_phone,String user_address,Long user_id);

     @Transactional
     @Modifying
     @Query(value ="update user a set a.user_password = ?1 where a.user_id = ?2", nativeQuery = true)
      void changeUserPassword(String user_password,Long user_id);
}
