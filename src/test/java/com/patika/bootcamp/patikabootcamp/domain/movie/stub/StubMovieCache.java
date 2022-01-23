package com.patika.bootcamp.patikabootcamp.domain.movie.stub;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MovieCachePort;

public class StubMovieCache implements MovieCachePort {

    public int interaction = 0;

    @Override
    public Movie retrieveMovie(Long movieId) {
        interaction++;

        if (movieId == 1)
            return Movie.builder()
                    .id(1L)
                    .director("test director")
                    .releaseYear(2000)
                    .build();

        return null;
    }

    @Override
    public void createMovie(Movie movie) {
        interaction++;
    }
}
