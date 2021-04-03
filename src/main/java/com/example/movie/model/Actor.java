package com.example.movie.model;

import com.example.movie.JPABasic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "actors")
public class Actor extends JPABasic {

    private String name;
    private String surname;
   // @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "actors_by_country")
    private Country country;
    @OneToOne
    @JoinColumn(name = "film_id")
    Film film;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdate;







}
