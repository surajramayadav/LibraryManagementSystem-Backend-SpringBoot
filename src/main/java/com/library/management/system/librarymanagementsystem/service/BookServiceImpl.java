package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
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
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public boolean addBook(HashMap<String, String> book) {
        boolean flag = false;
        System.out.println(book.get("book_name"));
        BookModel bookData = bookRepository.getBookByName(book.get("book_name"));
        // System.out.println(bookData);

        if (bookData != null) {
            if (bookData.getBook_name().equals(book.get("book_name"))) {
                long quantity = bookRepository.getBookQuantity(book.get("book_name"));
                System.out.println(quantity);
                long sum = quantity + Long.parseLong(book.get("book_quantity"));
                System.out.println(bookData.getBook_id());
                System.out.println(sum);
                bookRepository.updateBookQuantity(sum, bookData.getBook_id());
                System.out.println("Bookupadeted");
                flag = true;
            }

        } else {
            GenreModel genreData = genreRepository.getGenreDataByType(book.get("genre_type"));
            System.out.println(genreData);
            if (genreData != null) {

                System.out.println("no");
                if (genreData.getGenre_type().equals(book.get("genre_type"))) {

                    System.out.println("no");
                    BookModel newBook = new BookModel();
                    newBook.setBook_author(book.get("book_author"));
                    newBook.setBook_isbn(book.get("book_isbn"));
                    newBook.setBook_name(book.get("book_name"));
                    newBook.setBook_quantity(Long.parseLong(book.get("book_quantity")));
                    newBook.setGenreModel(genreData);

                    if (bookRepository.save(newBook) != null) {
                        System.out.println("added Successfully");
                        flag = true;
                    }
                }

            } else {

                GenreModel newGenre = new GenreModel();
                newGenre.setGenre_type(book.get("genre_type"));
                if (genreRepository.save(newGenre) != null) {
                    GenreModel newGenreData = genreRepository.getGenreDataByType(book.get("genre_type"));
                    System.out.print(newGenre);
                    BookModel newBook = new BookModel();
                    newBook.setBook_author(book.get("book_author"));
                    newBook.setBook_isbn(book.get("book_isbn"));
                    newBook.setBook_name(book.get("book_name"));
                    newBook.setBook_quantity(Long.parseLong(book.get("book_quantity")));
                    newBook.setGenreModel(newGenreData);
                    if (bookRepository.save(newBook) != null) {
                        System.out.println("added Successfully");
                        flag = true;
                    }

                }
            }
        }
        // genreService.addGenre(genre)
        // return bookRepository.addBook(book);
        return flag;
    }

    @Override
    public boolean deleteBook(Long book_id) {
        boolean flag = false;
        bookRepository.deleteById(book_id);
        if(!bookRepository.findById(book_id).isPresent()){
            flag =true;
        }
        return flag;
    }

    @Override
    public boolean updateBook(Long book_id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<BookModel> getAllBook() {
        List<BookModel> getBook = bookRepository.findAll();
        return getBook;
    }

    @Override
    public Optional<BookModel> getBookById(Long book_id) {
        Optional<BookModel> getBook = bookRepository.findById(book_id);
        return getBook;
    }

    @Override
    public HashMap<String, String> countBookByGenre() {
        return bookRepository.countBookByGenre();
         
    }

}
