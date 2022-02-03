package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
import java.util.List;

import com.library.management.system.librarymanagementsystem.model.IssuedBookModel;

import org.springframework.stereotype.Service;

@Service
public interface IssuedBookService {
   
    public boolean addIssueBook(HashMap<String,String> issueData);
    public boolean updateIssueStatus();
    public List<IssuedBookModel> getAllIssuedBook();
    public IssuedBookModel getIssuedBookByAdmin(long admin_id);
    public IssuedBookModel getIssuedBookByBook(long book_id);
    public IssuedBookModel getIssuedBookByUser(long user_id);
    public boolean retunIssuedBook (long user_id,String return_status,Long book_id);
    
}
