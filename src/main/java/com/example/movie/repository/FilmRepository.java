package com.example.movie.repository;

import com.example.movie.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Optional<Film> findFilmById(Integer id);

    Film findFilmByName(String name);

    @Transactional
    @Modifying
    void deleteById(Integer id);





}
