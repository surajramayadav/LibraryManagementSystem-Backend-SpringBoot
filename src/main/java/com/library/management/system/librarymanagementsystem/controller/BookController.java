package com.library.management.system.librarymanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.BookModel;
import com.library.management.system.librarymanagementsystem.model.GenreModel;
import com.library.management.system.librarymanagementsystem.repository.BookRepository;
import com.library.management.system.librarymanagementsystem.repository.GenreRepository;
import com.library.management.system.librarymanagementsystem.service.BookService;
import com.library.management.system.librarymanagementsystem.service.BookServiceImpl;
import com.library.management.system.librarymanagementsystem.service.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // get all books
    @GetMapping("/")
    public List<BookModel> getBook() {
        return bookService.getAllBook();
    }

    // get book by id
    @GetMapping("/{book_id}")
    public Optional<BookModel> getBookById(@PathVariable("book_id") Long book_id) {
        return bookService.getBookById(book_id);
    }


    //search book by name
    @GetMapping("/search/{book_name}")
    public Optional<BookModel> searchBook(@PathVariable("book_name") String book_name) {
        return bookService.searchBookName(book_name);
    }

    // checking book is exits or not
    @GetMapping("/exits/{book_name}")
    public boolean checkBookIsExits(@PathVariable("book_name") String book_name) {
        return bookService.checkBookIsExits(book_name);
    }

    //add book
    @PostMapping("/")
    public boolean addBook(@RequestBody HashMap<String, String> book) {
        return bookService.addBook(book);
    }

    //delete book
    @DeleteMapping("/{book_id}")
    public boolean deleteBook(@PathVariable("book_id") Long book_id) {
        return bookService.deleteBook(book_id);
    }

    //update book
    @PutMapping("/{book_id}")
    public boolean updateBook(@PathVariable("book_id") Long book_id, @RequestBody HashMap<String, String> bookData) {
        return bookService.updateBook(bookData.get("book_name"), bookData.get("book_isbn"), bookData.get("book_author"),
                bookData.get("genre_type"), Long.parseLong(bookData.get("book_quantity")), book_id);
    }

     //update book
     @PutMapping("/quantity")
     public boolean updateBookQuantity(@RequestBody HashMap<String, String> bookData) {
         System.out.println(bookData);
         return bookService.updateBookQuantity(bookData.get("book_name"), Long.parseLong(bookData.get("book_quantity")));
     }
 

    
}
