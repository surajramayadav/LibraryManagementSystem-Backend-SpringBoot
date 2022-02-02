package com.library.management.system.librarymanagementsystem.repository;

import javax.transaction.Transactional;

import com.library.management.system.librarymanagementsystem.model.AdminModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<AdminModel,Long>{
    

    // @Transactional
    // @Modifying
    // @Query("update admin a set a.admin_username = ?1,a.admin_role = ?2 where a.admin_id = ?3")
    //  void updateAdminById(String admin_username,String admin_role,Long admin_id);
}
