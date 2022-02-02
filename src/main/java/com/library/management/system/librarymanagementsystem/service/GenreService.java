package com.library.management.system.librarymanagementsystem.service;

import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.GenreModel;

public interface GenreService {
    
    public boolean addGenre(GenreModel gernr);
    public long getGenreById(Long genre_id);
}
