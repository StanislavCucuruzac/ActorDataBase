package com.example.movie.controller;

import com.example.movie.exception.ActorNotFoundException;
import com.example.movie.exception.CountryNotFoundException;
import com.example.movie.exception.FilmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionControllerAdvice {
    @ExceptionHandler(value = ActorNotFoundException.class)
    public ResponseEntity<Object> actorNotFoundException(ActorNotFoundException actorNotFoundException){
        return new ResponseEntity(actorNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<Object> countryNotFoundException(CountryNotFoundException countryNotFoundException){
        return new ResponseEntity(countryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = FilmNotFoundException.class)
    public ResponseEntity<Object> filmNotFoundException(FilmNotFoundException filmNotFoundException){
        return new ResponseEntity(filmNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
