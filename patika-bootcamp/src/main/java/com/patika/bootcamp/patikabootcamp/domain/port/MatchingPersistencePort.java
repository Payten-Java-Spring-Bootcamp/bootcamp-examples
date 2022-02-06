package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;

import java.util.List;

public interface MatchingPersistencePort {

    void create(Movie movie, List<Actor> actors);

    List<Actor> retrieveActorsByMovieId(Long movieId);
}
