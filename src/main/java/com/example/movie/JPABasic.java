package com.example.movie;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class JPABasic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
}
