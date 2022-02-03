package com.library.management.system.librarymanagementsystem.repository;

import com.library.management.system.librarymanagementsystem.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    
    @Query(value = "SELECT * FROM user res where res.user_id = ?1", nativeQuery = true)
    public UserModel getUser(Long user_id);
}
