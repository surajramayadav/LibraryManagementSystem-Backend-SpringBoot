package com.library.management.system.librarymanagementsystem.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="admin")

public class AdminModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long admin_id;
    @Column(name = "admin_username",unique = true)
    private String admin_username;
    @Column(name = "admin_password")
    private String admin_password;
    @Column(name = "admin_role")
    private String admin_role;

    


    public AdminModel() {
    }

    public AdminModel(Long admin_id, String admin_username, String admin_password, String admin_role,
            List<IssuedBookModel> getAllIssuedBookByAdmin) {
        this.admin_id = admin_id;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
        this.admin_role = admin_role;
        
    }






    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(String admin_role) {
        this.admin_role = admin_role;
    }

  
    @Override
    public String toString() {
        return "AdminModel [admin_id=" + admin_id + ", admin_password=" + admin_password + ", admin_role=" + admin_role
                + ", admin_username=" + admin_username + "]";
    }



    
}
