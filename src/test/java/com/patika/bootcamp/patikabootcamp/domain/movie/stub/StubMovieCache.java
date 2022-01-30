package com.patika.bootcamp.patikabootcamp.domain.movie.stub;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MovieCachePort;
import org.checkerframework.checker.nullness.Opt;

import java.util.Optional;

public class StubMovieCache implements MovieCachePort {

    public int interaction = 0;

    @Override
    public Optional<Movie> retrieveMovie(Long movieId) {
        interaction++;

        if (movieId == 1)
            return Optional.ofNullable(Movie.builder()
                    .id(1L)
                    .director("test director")
                    .releaseYear(2000)
                    .build());

        return Optional.empty();
    }

    @Override
    public void createMovie(Movie movie) {
        interaction++;
    }
}
