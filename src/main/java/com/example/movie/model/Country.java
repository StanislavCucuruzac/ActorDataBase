package com.example.movie.model;

import com.example.movie.JPABasic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "countries")
public class Country extends JPABasic {

    private String name;
   // @JsonIgnoreProperties("country")
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "actors_by_country")
    List<Actor> actorList= new ArrayList<>();
    public void addActorToList(Actor actor){
        actorList.add(actor);
    }

}
