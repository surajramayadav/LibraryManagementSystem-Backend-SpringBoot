package com.library.management.system.librarymanagementsystem.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.library.management.system.librarymanagementsystem.model.BookModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<BookModel,Long> {
    
    // get data from book Name
    @Query(value = "SELECT * FROM book res where res.book_name = ?1", nativeQuery = true)
    public BookModel getBookByName(String book_name);

    // get Book quantity
    @Query(value = "SELECT book_quantity FROM book res where res.book_name = ?1", nativeQuery = true)
    public long getBookQuantity(String book_name);    


    // update book quantity
    @Transactional
    @Modifying
    @Query(value = "update book a set a.book_quantity = ?1 where a.book_id = ?2", nativeQuery = true)
    public void updateBookQuantity(long book_quantity,long book_id);


    //Search A book like Operation
    @Query(value ="SELECT * FROM book res where res.book_name like ?1%", nativeQuery = true)
    public Optional<BookModel>  searchBookName(String book_name);

    //Update Book 
    @Transactional
    @Modifying
    @Query(value ="update book a set a.book_name = ?1,a.book_isbn = ?2,a.book_quantity = ?3 ,a.book_author = ?4,a.genre_id = ?5  where a.book_id = ?6", nativeQuery = true)
     void updatebookById(String book_name,String book_isbn,Long book_quantity,String book_author,Long genre_id,Long book_id);



     

    // get no of book by genre  #Report
    @Query(value = "select genre_type,count(*) as count from book inner join genre  on book.genre_id = genre.genre_id group by genre.genre_type", nativeQuery = true)
    public HashMap<String,String> countBookByGenre();
}
