package com.patika.bootcamp.patikabootcamp.movie.service;

import com.patika.bootcamp.patikabootcamp.movie.MovieGenre;
import com.patika.bootcamp.patikabootcamp.movie.repository.MovieEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Movie {

    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;

    MovieEntity convertToMovieEntity() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(getName());
        movieEntity.setDirector(getDirector());
        movieEntity.setReleaseYear(getReleaseYear());
        movieEntity.setGenre(getGenre());
        return movieEntity;
    }
}
