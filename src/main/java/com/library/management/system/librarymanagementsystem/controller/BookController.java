package com.library.management.system.librarymanagementsystem.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/book")
public class BookController {
    

    @GetMapping("/")
    public String getBook() {
        return "Get book";
    }

    @GetMapping("/{book_id}")
    public String getBookById(@PathVariable("book_id") Integer book_id){
        return "Get book Id"+book_id;
    }

    @PostMapping("/")
    public String addBook(){
        return "Add book";
    }

    @DeleteMapping("/{book_id}")
    public String deleteBook(@PathVariable("book_id") Integer book_id){
        return "delete book " +book_id;
    }

    @PutMapping("/{book_id}")
    public String updateBook(@PathVariable("book_id") Integer book_id){
        return "update book " +book_id;
    }
}
