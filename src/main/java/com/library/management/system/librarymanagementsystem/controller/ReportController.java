package com.library.management.system.librarymanagementsystem.controller;

import java.util.HashMap;

import com.library.management.system.librarymanagementsystem.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/report")
public class ReportController {
    @Autowired
    private BookService bookService; 

    @GetMapping("/count")
    public HashMap<String,String> getUserById(){
        return bookService.countBookByGenre();
    }
}
