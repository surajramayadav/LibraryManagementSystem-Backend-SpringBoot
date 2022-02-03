package com.library.management.system.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.library.management.system.librarymanagementsystem.model.GenreModel;

import org.springframework.stereotype.Service;
@Service
public interface GenreService {
    
    public boolean addGenre(GenreModel gernr);
    public long getGenreById(Long genre_id);

}
