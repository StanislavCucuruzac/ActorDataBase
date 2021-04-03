package com.example.movie.exception;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String message){
        super(message);
    }
}
