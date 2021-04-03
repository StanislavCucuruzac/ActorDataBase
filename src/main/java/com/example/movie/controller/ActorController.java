package com.example.movie.controller;

import com.example.movie.exception.ActorNotFoundException;
import com.example.movie.model.Actor;
import com.example.movie.model.Country;
import com.example.movie.repository.ActorRepository;
import com.example.movie.repository.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
@AllArgsConstructor
public class ActorController {
    ActorRepository actorRepository;
    CountryRepository countryRepository;
    @GetMapping
    public List<Actor> getAll(){
        return actorRepository.findAll();
    }
    @PostMapping
    public Actor createActor(@RequestBody Actor actor){
        return actorRepository.save(actor);
    }
    @GetMapping("/error")
    public String getError()  { // throws абработка исключение должен заняться тот кто будет вызывать метод getError
    // throw принудитеньное выброс исключение
        try {
            throw new ActorNotFoundException("error");
          //  System.exit(0);
        } catch (ActorNotFoundException actorNotFoundException) {
            System.out.println("catch");
        }catch (RuntimeException runtimeException) {
            System.out.println("runtime exeptio");
        } catch (Exception exception){
            System.out.println("exeption");
        }
        finally {
           // throw new ActorNotFoundException();
            return "finaly";
        }

    }
    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable int id) throws ActorNotFoundException {
        return actorRepository.findActorById(id).orElseThrow(()-> new ActorNotFoundException("actor this id "+id+ " not found"));
    }

    @GetMapping("/name/{name}")
    public Actor getActorByName(@PathVariable String name){
        try {
            getError();
        } catch (Exception actorNotFoundException) {
            actorNotFoundException.printStackTrace();
        }
        return actorRepository.findActorByName(name);
    }
    @GetMapping("/surname/{surname}")
    public Actor getActorBySurname(@PathVariable String surname){
        return actorRepository.findActorBySurname(surname);
    }
    @DeleteMapping("/{id}")
    public void deleteActorById(@PathVariable int id){
        actorRepository.deleteById(id);
    }





}
