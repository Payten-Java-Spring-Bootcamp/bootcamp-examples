package com.patika.bootcamp.patikabootcamp.movie.repository;

import com.patika.bootcamp.patikabootcamp.movie.MovieGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;
}
