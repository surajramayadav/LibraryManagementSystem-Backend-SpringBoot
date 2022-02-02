package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.BookModel;

public interface BookService {
    
   public boolean addBook(BookModel book);
   public boolean deleteBook(Long book_id);
   public boolean updateBook(Long book_id);
   public List<BookModel> getAllBook();
   public Optional<BookModel> getBookById(Long book_id); 
}
