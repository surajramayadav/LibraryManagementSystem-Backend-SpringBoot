package com.library.management.system.librarymanagementsystem.service;

import com.library.management.system.librarymanagementsystem.model.IssuedBookModel;
import com.library.management.system.librarymanagementsystem.repository.IssuedBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

    @Autowired
    private IssuedBookRepository issueRepo;
    @Override
    public boolean addIssueBook(IssuedBookModel issuedBookModel) {
        boolean flag = false;
        try {
            if(issueRepo.save(issuedBookModel) != null){
                flag=true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return flag;
    }

    @Override
    public boolean updateIssueStatus() {
        // TODO Auto-generated method stub
        return false;
    }
    
   
}
