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
import java.util.Optional;

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
        Optional<MovieEntity> movieEntityOptional = movieJpaRepository.findById(id);

        if (movieEntityOptional.isPresent())
            return movieEntityOptional.get().toModel();
        else
            throw new PatikaDataNotFoundException(ExceptionType.MOVIE_DATA_NOT_FOUND, "Movie id:" + id);
    }

    @Override
    public List<Movie> retrieveByActorId(Long actorId) {
        Optional<ActorEntity> actorEntityOptional = actorJpaRepository.findById(actorId);

        if (actorEntityOptional.isPresent())
            return actorEntityOptional.get()
                    .getMatchings()
                    .stream()
                    .map(MatchingEntity::getMovie)
                    .map(MovieEntity::toModel)
                    .toList();
        else
            throw new PatikaDataNotFoundException(ExceptionType.ACTOR_DATA_NOT_FOUND);
    }

    @Override
    public void delete(Long id) {
        Optional<MovieEntity> optionalMovieEntity = movieJpaRepository.findById(id);

        if (optionalMovieEntity.isPresent()) {
            MovieEntity entity = optionalMovieEntity.get();
            entity.setStatus(Status.DELETED);
            movieJpaRepository.save(entity);
        }
    }
}
