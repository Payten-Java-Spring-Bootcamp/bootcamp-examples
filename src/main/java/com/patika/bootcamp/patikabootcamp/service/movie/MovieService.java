package com.patika.bootcamp.patikabootcamp.service.movie;

import com.patika.bootcamp.patikabootcamp.service.actor.Actor;

import java.util.List;

public interface MovieService {

    Long create(Movie movie, List<Actor> actors, List<Long> actorIds);

    Movie retrieve(Long id);

    void delete(Long id);
}
