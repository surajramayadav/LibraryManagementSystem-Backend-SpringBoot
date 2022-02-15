package com.library.management.system.librarymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.exception.ResourceNotFoundException;
import com.library.management.system.librarymanagementsystem.model.BookModel;
import com.library.management.system.librarymanagementsystem.model.GenreModel;
import com.library.management.system.librarymanagementsystem.repository.BookRepository;
import com.library.management.system.librarymanagementsystem.repository.GenreRepository;
import com.library.management.system.librarymanagementsystem.repository.IssuedBookRepository;
import com.library.management.system.librarymanagementsystem.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private ApiResponse apiResponse = null;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private IssuedBookRepository issuedRepo;

    public BookServiceImpl() {
        apiResponse = new ApiResponse();
    }

    @Override
    public HashMap<String, Boolean> addBook(HashMap<String, String> book) {
        boolean flag = false;
        // get genre info using book name
        GenreModel genreData = genreRepository.getGenreDataByType(book.get("genre_type"));
        // System.out.println(genreData);
        // checking genre is exists or not 
        if (genreData != null) {
            // adding book
            if (genreData.getGenre_type().equals(book.get("genre_type"))) {
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
            // genre is not found then adding genre
            GenreModel newGenre = new GenreModel();
            newGenre.setGenre_type(book.get("genre_type"));
            if (genreRepository.save(newGenre) != null) {
                GenreModel newGenreData = genreRepository.getGenreDataByType(book.get("genre_type"));
                // System.out.print(newGenre);
                //adding book
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

        return apiResponse.addKeyValue(flag);
    }

    @Override
    public HashMap<String, Boolean> deleteBook(Long book_id) {
        boolean flag = false;

        if (bookRepository.findById(book_id).isPresent()) {
            // first delete Constarints

            issuedRepo.deleteIssuedbookByBook(book_id);
            bookRepository.deleteById(book_id);
            if (!bookRepository.findById(book_id).isPresent()) {
                flag = true;
            }
        } else {
            System.out.println("Book Not Found");
            throw new ResourceNotFoundException("Book Not Found");
        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public List<BookModel> getAllBook() {
        List<BookModel> getBook = bookRepository.findAll();
        return getBook;
    }

    @Override
    public Optional<BookModel> getBookById(Long book_id) {
        Optional<BookModel> getBook = bookRepository.findById(book_id);
        if (!getBook.isPresent()) {
            System.out.println("Book Not Found");
            throw new ResourceNotFoundException("Book Not Found");

        }
        return getBook;
    }

    @Override
    public Optional<BookModel> searchBookName(String book_name) {
        return bookRepository.searchBookName(book_name);
    }

    @Override
    public HashMap<String, Boolean> checkBookIsExits(String book_name) {
        boolean flag = false;
        BookModel isBookExits = bookRepository.getBookByName(book_name);
        if (isBookExits != null) {
            flag = true;
        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public HashMap<String, Boolean> updateBook(String book_name, String book_isbn, String book_author,
            String genre_type,
            Long book_quantity, Long book_id) {
        boolean flag = false;
        // checking book is exists
        Optional<BookModel> bookData = bookRepository.findById(book_id);
        if (bookData.isPresent()) {
            GenreModel genreModel = genreRepository.getGenreDataByType(genre_type);
            // checking genre exists or not
            if (genreModel != null) {
                if (genreModel.getGenre_type().equals(genre_type)) {
                    bookRepository.updatebookById(book_name, book_isbn, book_quantity, book_author,
                            genreModel.getGenre_id(), book_id);
                    flag = true;
                }
            } else {
                // user enter new genre
                GenreModel newGenre = new GenreModel();
                newGenre.setGenre_type(genre_type);
                if (genreRepository.save(newGenre) != null) {
                    GenreModel getGenreModel = genreRepository.getGenreDataByType(genre_type);
                    bookRepository.updatebookById(book_name, book_isbn, book_quantity, book_author,
                            getGenreModel.getGenre_id(), book_id);
                    flag = true;
                }
            }
        } else {
            System.out.println("Book Not Found");
            throw new ResourceNotFoundException("Book Not Found");

        }
        return apiResponse.addKeyValue(flag);
    }

    @Override
    public HashMap<String, Boolean> updateBookQuantity(String book_name, long book_quantity) {
        boolean flag = false;
        BookModel bookData = bookRepository.getBookByName(book_name);
        System.out.println(bookData);
        if (bookData != null) {

            long quantity = bookRepository.getBookQuantity(book_name);
            System.out.println(quantity);
            long sum = quantity + book_quantity;
            // System.out.println(bookData.getBook_id());
            System.out.println(sum);
            bookRepository.updateBookQuantity(sum, bookData.getBook_id());
            System.out.println("Book Quantity updated");
            flag = true;

        }
        return apiResponse.addKeyValue(flag);
    }

}
