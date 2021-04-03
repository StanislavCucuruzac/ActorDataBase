package com.example.movie.controller;

import com.example.movie.exception.FilmNotFoundException;
import com.example.movie.model.Film;
import com.example.movie.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
@AllArgsConstructor
public class FilmController {
    FilmRepository filmRepository;
    @GetMapping
    public List<Film> getAll(){
        return filmRepository.findAll();
    }
    @PostMapping
    public Film createFilm(@RequestBody Film film){
        return filmRepository.save(film);
    }
    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable int id) throws FilmNotFoundException {
        return filmRepository.findFilmById(id).orElseThrow(()-> new FilmNotFoundException("this film with id"+ id+ " not exist"));
    }
    @GetMapping("/name/{name}")
    public Film getFilmByName(@PathVariable String name){
        return filmRepository.findFilmByName(name);
    }
    @DeleteMapping("/{id}")
    public void deleteFiml(@PathVariable int id){
        filmRepository.deleteById(id);
    }

}
