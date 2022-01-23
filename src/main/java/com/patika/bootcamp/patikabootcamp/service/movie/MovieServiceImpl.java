package com.patika.bootcamp.patikabootcamp.service.movie;

import com.patika.bootcamp.patikabootcamp.repository.actor.ActorDao;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingDao;
import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingEntity;
import com.patika.bootcamp.patikabootcamp.repository.movie.MovieDao;
import com.patika.bootcamp.patikabootcamp.repository.movie.MovieEntity;
import com.patika.bootcamp.patikabootcamp.service.actor.Actor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j //todo log levels
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;
    private final ActorDao actorDao;
    private final MatchingDao matchingDao;
    private final RedisTemplate<String, Movie> movieRedisTemplate;

    @Override
    @Transactional
    public Long create(Movie movie, List<Actor> actors, List<Long> actorIds) {
        List<ActorEntity> existingActors = retrieveExistingActors(actorIds);
        List<ActorEntity> createdActors = createActors(actors);
        MovieEntity createdMovie = movieDao.save(movie.convertToMovieEntity());

        ArrayList<ActorEntity> actorEntities = new ArrayList<>();
        actorEntities.addAll(existingActors);
        actorEntities.addAll(createdActors);

        List<MatchingEntity> matchingEntities = actorEntities.stream()
                .map(actorEntity -> {
                    MatchingEntity matchingEntity = new MatchingEntity();
                    matchingEntity.setMovie(createdMovie);
                    matchingEntity.setActor(actorEntity);
                    return matchingEntity;
                }).collect(Collectors.toList());

        matchingDao.create(matchingEntities);
        return createdMovie.getId();
    }

    private List<ActorEntity> createActors(List<Actor> actors) {
        if (!CollectionUtils.isEmpty(actors)) {
            List<ActorEntity> actorEntities = actors.stream()
                    .map(Actor::convertToActorEntity)
                    .collect(Collectors.toList());

            return actorDao.create(actorEntities);
        }

        return new ArrayList<>();
    }

    private List<ActorEntity> retrieveExistingActors(List<Long> actorIds) {
        if (!CollectionUtils.isEmpty(actorIds)) {
            List<ActorEntity> retrievedActors = actorDao.retrieve(actorIds);

            if (retrievedActors.size() < actorIds.size()) {
                throw new RuntimeException("Verilen actor id db'de bulunamamıştır");
            }

            return retrievedActors;
        }

        return new ArrayList<>();
    }

    /* film N - N actor

    Cast
    film 1 -> actor1, actor3, actor4
    film2 -> actor1, actor 2,actor 5, actor 4
    film3 -> actor 2, actor3, actor4

    Matching
    film1-id, actor1-id
    film1-id, actor3-id
    film1-id, actor4-id
    film2-id, actor1-id
    ............

     */

    @Override
    public Movie retrieve(Long id) {
        Movie movie = movieRedisTemplate.opsForValue().get("patika:movie:" + id);
        log.info("Movie is retrieving: {}", id);

        if(movie == null) {
            log.info("Movie cache is updating: {}", id);
            MovieEntity entity = movieDao.retrieve(id);
            movie = Movie.convertFrom(entity);
            movieRedisTemplate.opsForValue().set("patika:movie:" + id, movie, Duration.ofSeconds(30));
        }

        return movie;
    }

    @Override
    public void delete(Long id) {
        movieDao.delete(id);
    }
}
