package com.library.management.system.librarymanagementsystem.service;

import com.library.management.system.librarymanagementsystem.model.IssuedBookModel;

public interface IssuedBookService {
   
    public boolean addIssueBook(IssuedBookModel issuedBookModel);
    public boolean updateIssueStatus();
    
}
