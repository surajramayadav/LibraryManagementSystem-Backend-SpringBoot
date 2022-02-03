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
    
    @Query(value = "SELECT * FROM book res where res.book_name = ?1", nativeQuery = true)
    public BookModel getBookByName(String book_name);

    @Query(value = "SELECT book_quantity FROM book res where res.book_name = ?1", nativeQuery = true)
    public long getBookQuantity(String book_name);    


    @Transactional
    @Modifying
    @Query(value = "update book a set a.book_quantity = ?1 where a.book_id = ?2", nativeQuery = true)
    public void updateBookQuantity(long book_quantity,long book_id);

    @Query(value = "select gk.genre_type,count(*) as count from book bk inner join genre gk on bk.genre_id = gk.genre_id group by gk.genre_type", nativeQuery = true)
    public HashMap<String,String> countBookByGenre();

   
}
