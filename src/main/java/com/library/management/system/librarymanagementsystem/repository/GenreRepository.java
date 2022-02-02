package com.library.management.system.librarymanagementsystem.repository;

import java.util.List;

import com.library.management.system.librarymanagementsystem.model.GenreModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends JpaRepository<GenreModel,Long>{
    
    // List<GenreModel> findByGenre_type(String genre_type);
}
