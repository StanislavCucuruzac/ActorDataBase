package com.example.movie.repository;

import com.example.movie.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findCountryById(Integer id);

    Country findCoutryByName(String name);

    @Transactional
    @Modifying
    void deleteById(Integer id);




}
