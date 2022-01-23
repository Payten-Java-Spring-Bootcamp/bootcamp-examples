package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;

public interface MovieCachePort {
    Movie retrieveMovie(Long movieId);

    void createMovie(Movie movie);
}
