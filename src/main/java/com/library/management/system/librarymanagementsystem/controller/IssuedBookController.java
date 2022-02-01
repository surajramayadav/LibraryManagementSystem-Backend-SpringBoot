package com.library.management.system.librarymanagementsystem.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/api/v1/issuedbook")
public class IssuedBookController {
    

    @GetMapping("/")
    public String getIssuedBook() {
        return "Get issuedBook";
    }

    @GetMapping("/{issuedBook_id}")
    public String getIssuedBookById(@PathVariable("issuedBook_id") Integer issuedBook_id){
        return "Get issuedBook Id"+issuedBook_id;
    }

    @PostMapping("/")
    public String addIssuedBook(){
        return "Add issuedBook";
    }

    @DeleteMapping("/{issuedBook_id}")
    public String deleteIssuedBook(@PathVariable("issuedBook_id") Integer issuedBook_id){
        return "delete issuedBook " +issuedBook_id;
    }

    @PutMapping("/{issuedBook_id}")
    public String updateIssuedBook(@PathVariable("issuedBook_id") Integer issuedBook_id){
        return "update issuedBook " +issuedBook_id;
    }
}
