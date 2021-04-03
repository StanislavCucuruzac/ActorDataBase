package com.example.movie.model;

import com.example.movie.Genre;
import com.example.movie.JPABasic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "films")
public class Film extends JPABasic {

    private String name;
    private String language;
    @OneToOne(mappedBy = "film",fetch = FetchType.EAGER)
    private Actor actor;
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
