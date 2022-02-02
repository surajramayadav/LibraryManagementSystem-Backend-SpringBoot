package com.library.management.system.librarymanagementsystem.model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_phone",unique = true)
    private Long user_phone;
    @Column(name = "user_address")
    private String user_address;

   
    public UserModel() {
    }

    public UserModel(Long user_id, String user_name, Long user_phone, String user_address,
            List<IssuedBookModel> getAllIssuedBookByUser) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_address = user_address;
        
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
