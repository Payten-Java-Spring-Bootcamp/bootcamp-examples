package com.patika.bootcamp.patikabootcamp.domain.movie.stub;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;

import java.util.List;

public class StubMoviePersistence implements MoviePersistencePort {

    public int interaction = 0;

    @Override
    public Movie save(Movie movie) {
        interaction++;
        return null;
    }

    @Override
    public Movie retrieve(Long id) {
        interaction++;
        if (id == 2)
            return Movie.builder()
                    .id(2L)
                    .director("test director")
                    .releaseYear(2000)
                    .build();
        return null;
    }

    @Override
    public List<Movie> retrieveByActorId(Long actorId) {
        interaction++;
        return null;
    }

    @Override
    public void delete(Long id) {
        interaction++;
    }
}
