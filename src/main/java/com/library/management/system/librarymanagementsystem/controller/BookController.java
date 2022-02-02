package com.library.management.system.librarymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.BookModel;
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
@RequestMapping(path="/api/v1/book")
public class BookController {
    
    @Autowired
    private BookService bookService; 


    // @Autowired
    // private GenreService genreService; 

    @GetMapping("/")
    public List<BookModel> getBook() {
        return  bookService.getAllBook();
    }

    @GetMapping("/{book_id}")
    public Optional<BookModel> getBookById(@PathVariable("book_id") Long book_id){
        return bookService.getBookById(book_id);
    }

    @PostMapping("/")
    public boolean addBook(@RequestBody BookModel book){
        System.out.println(book);
        // genreService.addGenre(genre)
        return bookService.addBook(book);
    }

    @DeleteMapping("/{book_id}")
    public String deleteBook(@PathVariable("book_id") Integer book_id){
        return "delete book " +book_id;
    }

    @PutMapping("/{book_id}")
    public String updateBook(@PathVariable("book_id") Integer book_id){
        return "update book " +book_id;
    }
}
