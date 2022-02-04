package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;

import com.library.management.system.librarymanagementsystem.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{
    

    @Autowired
    private BookRepository bookRepo;

    @Override
    public HashMap<String, String> countBookByGenre() {
        return bookRepo.countBookByGenre();

    }
}
