package com.library.management.system.librarymanagementsystem.controller;

import java.util.HashMap;

import com.library.management.system.librarymanagementsystem.service.BookService;
import com.library.management.system.librarymanagementsystem.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/report")
public class ReportController {
    @Autowired
    private ReportService reportService; 

    @GetMapping("/count")
    public HashMap<String,String> getUserById(){
        System.out.println(reportService.countBookByGenre());
        return reportService.countBookByGenre();
    }
}
