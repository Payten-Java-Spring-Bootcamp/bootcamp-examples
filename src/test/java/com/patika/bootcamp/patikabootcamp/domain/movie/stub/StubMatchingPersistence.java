package com.patika.bootcamp.patikabootcamp.domain.movie.stub;

import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MatchingPersistencePort;

import java.util.List;

public class StubMatchingPersistence implements MatchingPersistencePort {
    @Override
    public void create(Movie movie, List<Actor> actors) {

    }

    @Override
    public List<Actor> retrieveActorsByMovieId(Long movieId) {
        return null;
    }
}
