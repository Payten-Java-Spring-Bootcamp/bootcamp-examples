package com.patika.bootcamp.patikabootcamp.repository.matching;

import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;

import java.util.List;

public interface MatchingDao {

    void create(List<MatchingEntity> matchingEntityList);

    List<ActorEntity> retrieveActorsByMovieId(Long movieId);
}
