package com.example.movie.repository;

import com.example.movie.model.Actor;
import com.example.movie.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Optional<Actor> findActorById(Integer id);

    Actor findActorByName(String name);
    Actor findActorBySurname(String surname);

    @Transactional
    @Modifying
    void deleteById(Integer id);
}

// new String

// repository

