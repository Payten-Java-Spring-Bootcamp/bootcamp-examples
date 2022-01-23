package com.patika.bootcamp.patikabootcamp.domain.actor;

import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import com.patika.bootcamp.patikabootcamp.domain.port.ActorPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MatchingPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorPersistencePort actorPersistencePort;
    private final MoviePersistencePort moviePersistencePort;
    private final MatchingPersistencePort matchingPersistencePort;

    @Override
    public Long create(Actor actor) {
        return actorPersistencePort.create(actor);
    }

    @Override
    public List<Movie> retrieveMovies(Long actorId) {
        return moviePersistencePort.retrieveByActorId(actorId);
    }

    @Override
    public List<Actor> retrieveActors(Long movieId) {
        return matchingPersistencePort.retrieveActorsByMovieId(movieId);
    }
}
