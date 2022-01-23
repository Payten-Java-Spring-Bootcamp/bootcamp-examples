package com.patika.bootcamp.patikabootcamp.domain.actor;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;

import java.util.List;

public interface ActorService {

    Long create(Actor actor);

    List<Movie> retrieveMovies(Long actor);

    List<Actor> retrieveActors(Long movieId);
}
