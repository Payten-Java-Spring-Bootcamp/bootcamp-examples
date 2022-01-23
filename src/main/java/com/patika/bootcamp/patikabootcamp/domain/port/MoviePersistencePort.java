package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;

import java.util.List;

public interface MoviePersistencePort {

    Movie save(Movie movie);

    Movie retrieve(Long id);

    List<Movie> retrieveByActorId(Long actorId);

    void delete(Long id);
}
