package com.patika.bootcamp.patikabootcamp.adapter.jpa.matching;

import com.patika.bootcamp.patikabootcamp.adapter.jpa.actor.ActorEntity;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.movie.MovieEntity;
import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MatchingPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingJpaAdapter implements MatchingPersistencePort {

    private final MatchingJpaRepository matchingJpaRepository;

    @Override
    public void create(Movie movie, List<Actor> actors) {
        List<MatchingEntity> matchingEntities = actors.stream()
                .map(actorEntity -> {
                    MatchingEntity matchingEntity = new MatchingEntity();
                    matchingEntity.setMovie(MovieEntity.from(movie));
                    matchingEntity.setActor(ActorEntity.from(actorEntity));
                    return matchingEntity;
                }).toList();

        matchingJpaRepository.saveAll(matchingEntities);
    }

    @Override
    public List<Actor> retrieveActorsByMovieId(Long movieId) {
        return matchingJpaRepository.findAllByMovie_Id(movieId)
                .stream()
                .map(MatchingEntity::getActor)
                .map(ActorEntity::toModel)
                .toList();
    }
}
