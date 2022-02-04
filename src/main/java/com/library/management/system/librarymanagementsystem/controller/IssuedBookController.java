package com.library.management.system.librarymanagementsystem.controller;
import java.util.HashMap;
import java.util.List;

import com.library.management.system.librarymanagementsystem.model.IssuedBookModel;
import com.library.management.system.librarymanagementsystem.service.IssuedBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/api/v1/issuedbook")
public class IssuedBookController {
    

    @Autowired
    private IssuedBookService issuedBookService;

    // get all issuedBook 
    @GetMapping("/")
    public List<IssuedBookModel> getIssuedBook() {
        return issuedBookService.getAllIssuedBook();
    }

    // get issuedbook by id
    @GetMapping("/{issuedBook_id}")
    public String getIssuedBookById(@PathVariable("issuedBook_id") Long issuedBook_id){
        return "Get issuedBook Id"+issuedBook_id;
    }

    // get issued book by ids
    @GetMapping("/admin/{admin_id}")
    public IssuedBookModel getIssuedBookByAdmin(@PathVariable("admin_id") Long admin_id) {
        return issuedBookService.getIssuedBookByAdmin(admin_id);
    }
    @GetMapping("/book/{book_id}")
    public IssuedBookModel getIssuedBookByBook(@PathVariable("book_id") Long book_id) {
        return issuedBookService.getIssuedBookByBook(book_id);
    }
    @GetMapping("/user/{user_id}")
    public IssuedBookModel getIssuedBookByUser(@PathVariable("user_id") Long user_id)  {
        return issuedBookService.getIssuedBookByUser(user_id);
    }


    // issua a book

    @PostMapping("/")
    public boolean addIssuedBook(@RequestBody HashMap<String,String> issueData){
        return issuedBookService.addIssueBook(issueData);
    }

    // delete issued book
    @DeleteMapping("/{issuedBook_id}")
    public String deleteIssuedBook(@PathVariable("issuedBook_id") Integer issuedBook_id){
        return "delete issuedBook " +issuedBook_id;
    }


    // update issued book
    @PutMapping("/{issuedBook_id}")
    public String updateIssuedBook(@PathVariable("issuedBook_id") Integer issuedBook_id){
        return "update issuedBook " +issuedBook_id;
    }


    // return issued book
    @PutMapping("/return")
    public boolean updateIssuedBook(@RequestBody HashMap<String,String> retunData){
        long book_id=Long.parseLong(retunData.get("book_id"));
        long user_id=Long.parseLong(retunData.get("user_id"));
        String return_status=retunData.get("return_status");
        return issuedBookService.retunIssuedBook(user_id,return_status,book_id);
    }
}
