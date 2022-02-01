package com.library.management.system.librarymanagementsystem.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/genre")
public class GenreController {
    
    @GetMapping("/{genre_id}")
    public String getGenreById(@PathVariable("genre_id") Integer genre_id){
        return "Get genre Id"+genre_id;
    }

    @PostMapping("/")
    public String addGenre(){
        return "Add genre";
    }
}
