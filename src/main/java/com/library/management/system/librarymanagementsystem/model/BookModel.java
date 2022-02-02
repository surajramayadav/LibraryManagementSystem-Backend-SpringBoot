package com.library.management.system.librarymanagementsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")

public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;
    @Column(name="book_name",unique = true)
    private String book_name;
    @Column(name = "book_isbn",unique = true)
    private String book_isbn;
    @Column(name = "book_quantity")
    private Long book_quantity;
    @Column(name = "book_author")
    private String book_author;
  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id",nullable = false)
    private GenreModel genreModel;



    public BookModel() {

    }


    public BookModel(Long book_id, String book_name, String book_isbn, Long book_quantity, String book_author,
            GenreModel genreModel) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_isbn = book_isbn;
        this.book_quantity = book_quantity;
        this.book_author = book_author;
        this.genreModel = genreModel;
    }




    public Long getBook_id() {
        return book_id;
    }




    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }




    public String getBook_name() {
        return book_name;
    }




    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }




    public String getBook_isbn() {
        return book_isbn;
    }




    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }




    public Long getBook_quantity() {
        return book_quantity;
    }




    public void setBook_quantity(Long book_quantity) {
        this.book_quantity = book_quantity;
    }




    public String getBook_author() {
        return book_author;
    }




    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }




    public GenreModel getGenreModel() {
        return genreModel;
    }




    public void setGenreModel(GenreModel genreModel) {
        this.genreModel = genreModel;
    }




    @Override
    public String toString() {
        return "BookModel [book_author=" + book_author + ", book_id=" + book_id + ", book_isbn=" + book_isbn
                + ", book_name=" + book_name + ", book_quantity=" + book_quantity + ", genreModel=" + genreModel + "]";
    }
    

    
    
     
}
