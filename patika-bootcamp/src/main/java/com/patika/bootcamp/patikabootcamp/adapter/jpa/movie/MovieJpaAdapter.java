package com.patika.bootcamp.patikabootcamp.adapter.jpa.movie;

import com.patika.bootcamp.patikabootcamp.adapter.jpa.actor.ActorEntity;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.actor.ActorJpaRepository;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.common.Status;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.matching.MatchingEntity;
import com.patika.bootcamp.patikabootcamp.domain.exception.ExceptionType;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaDataNotFoundException;
import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieJpaAdapter implements MoviePersistencePort {

    private final MovieJpaRepository movieJpaRepository;
    private final ActorJpaRepository actorJpaRepository;

    @Override
    public Movie save(Movie movie) {
        MovieEntity movieEntity = MovieEntity.from(movie);
        return movieJpaRepository.save(movieEntity).toModel();
    }

    @Override
    public Movie retrieve(Long id) {
        return movieJpaRepository.findById(id)
                .map(MovieEntity::toModel)
                .orElseThrow(() -> new PatikaDataNotFoundException(ExceptionType.MOVIE_DATA_NOT_FOUND, "Movie id:" + id));
    }

    @Override
    public List<Movie> retrieveByActorId(Long actorId) {
        return actorJpaRepository.findById(actorId)
                .map(ActorEntity::getMatchings)
                .orElseThrow(() -> new PatikaDataNotFoundException(ExceptionType.ACTOR_DATA_NOT_FOUND))
                .stream()
                .map(MatchingEntity::getMovie)
                .map(MovieEntity::toModel)
                .toList();
    }

    @Override
    public void delete(Long id) {
        movieJpaRepository.findById(id)
                .ifPresent(movie -> {
                    movie.setStatus(Status.DELETED);
                    movieJpaRepository.save(movie);
                });
    }
}
