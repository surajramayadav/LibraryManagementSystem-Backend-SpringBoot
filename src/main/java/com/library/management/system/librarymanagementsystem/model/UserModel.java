package com.library.management.system.librarymanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_phone", unique = true)
    private Long user_phone;
    @Column(name = "user_address")
    private String user_address;
    @Column(name = "user_email",unique = true,nullable = false)
    private String user_email;

    @Column(name = "user_password", nullable = false)
    private String user_password = "123456";

    public UserModel() {
    }

   

    // public String getUser_password() {
    // return user_password;
    // }

    public UserModel(Long user_id, String user_name, Long user_phone, String user_address, String user_email,
            String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_email = user_email;
        this.user_password = user_password;
    }



    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }



    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }



    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "UserModel [ user_address=" + user_address
                + ", user_id=" + user_id + ", user_name=" + user_name + ", user_phone=" + user_phone + "]";
    }

}
