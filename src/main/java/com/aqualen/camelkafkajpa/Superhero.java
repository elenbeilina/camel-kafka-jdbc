package com.aqualen.camelkafkajpa;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Entity
@Table(name = "superheroes")
public class Superhero {

    @Id
    @GeneratedValue
    private int id;
    private String superhero;
    private String publisher;
    private String alter_ego;
    private String first_appearance;
    private String characters;
}
