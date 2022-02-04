package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.BookModel;

import org.springframework.stereotype.Service;
@Service
public interface BookService {
    
   public boolean addBook(HashMap<String,String> book);
   public boolean deleteBook(Long book_id);
   public boolean updateBook(String book_name,String book_isbn,String book_author,String genre_type,Long book_quantity, Long book_id);
   public List<BookModel> getAllBook();
   public Optional<BookModel> getBookById(Long book_id); 
   public Optional<BookModel> searchBookName(String book_name);
   public boolean checkBookIsExits(String book_name);
   public boolean updateBookQuantity(String book_name,long book_quantity);
}
