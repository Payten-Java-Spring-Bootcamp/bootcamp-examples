package com.patika.bootcamp.patikabootcamp.domain.movie.stub;

import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import com.patika.bootcamp.patikabootcamp.domain.port.ActorPersistencePort;

import java.util.List;

public class StubActorPersistence implements ActorPersistencePort {
    @Override
    public Long create(Actor actor) {
        return null;
    }

    @Override
    public List<Actor> create(List<Actor> actors) {
        return null;
    }

    @Override
    public List<Actor> retrieve(List<Long> actorIds) {
        return null;
    }
}
