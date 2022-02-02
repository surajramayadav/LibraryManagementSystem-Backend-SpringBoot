package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.BookModel;
import com.library.management.system.librarymanagementsystem.model.GenreModel;
import com.library.management.system.librarymanagementsystem.repository.BookRepository;
import com.library.management.system.librarymanagementsystem.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

   
    @Autowired
    private BookRepository bookRepository;


    @Override
    public boolean addBook(BookModel book) {
        boolean flag = false;
        try {
            if(bookRepository.save(book) != null){
                flag=true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return flag;
    }

    @Override
    public boolean deleteBook(Long book_id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateBook(Long book_id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<BookModel> getAllBook() {
       List<BookModel> getBook=bookRepository.findAll();
        return getBook;
    }

    @Override
    public Optional<BookModel> getBookById(Long book_id) {
       Optional<BookModel> getBook=bookRepository.findById(book_id);
        return getBook;
    }

}
