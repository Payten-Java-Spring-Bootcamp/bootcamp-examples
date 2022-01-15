package com.patika.bootcamp.patikabootcamp.service.actor;

import com.patika.bootcamp.patikabootcamp.service.movie.Movie;

import java.util.List;

public interface ActorService {

    Long create(Actor actor);

    List<Movie> retrieveMovies(Long actor);
}
