package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    
    public HashMap<String,String> countBookByGenre();
}
