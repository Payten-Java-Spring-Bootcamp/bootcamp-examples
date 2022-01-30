package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;

import java.util.Optional;

public interface MovieCachePort {

    Optional<Movie> retrieveMovie(Long movieId);

    void createMovie(Movie movie);
}
