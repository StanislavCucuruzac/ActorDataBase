package com.example.movie.controller;

import com.example.movie.exception.ActorNotFoundException;
import com.example.movie.exception.CountryNotFoundException;
import com.example.movie.model.Actor;
import com.example.movie.model.Country;
import com.example.movie.repository.ActorRepository;
import com.example.movie.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {
    CountryRepository countryRepository;
    ActorRepository actorRepository;
    @GetMapping
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country){
        return countryRepository.save(country);
    }
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id) throws CountryNotFoundException {
        return countryRepository.findCountryById(id).orElseThrow(()-> new CountryNotFoundException("country with id "+ id +" not found"));
    }
    @GetMapping("/name/{name}")
    public Country getCountryByName(@PathVariable String name){
        return countryRepository.findCoutryByName(name);
    }
    @DeleteMapping("{id}")
    public void deleteCountry(@PathVariable int id){
        countryRepository.deleteById(id);
    }
    @GetMapping("/addActor")
    public Country addActor(@RequestParam int actorId,@RequestParam int countryId) throws ActorNotFoundException {
        Actor actor= actorRepository.findActorById(actorId).orElseThrow(()->new ActorNotFoundException("can not add actor because actor with id not found"));
        Country country= countryRepository.findCountryById(countryId).get();
        country.addActorToList(actor);
        return countryRepository.save(country);
    }


}
