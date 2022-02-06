package com.patika.bootcamp.patikabootcamp.domain.movie;

import com.patika.bootcamp.patikabootcamp.domain.movie.stub.StubActorPersistence;
import com.patika.bootcamp.patikabootcamp.domain.movie.stub.StubMatchingPersistence;
import com.patika.bootcamp.patikabootcamp.domain.movie.stub.StubMovieCache;
import com.patika.bootcamp.patikabootcamp.domain.movie.stub.StubMoviePersistence;
import com.patika.bootcamp.patikabootcamp.domain.port.ActorPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MatchingPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MovieCachePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieServiceTestWithStub {

    MovieService movieService;
    MoviePersistencePort moviePersistencePort;
    ActorPersistencePort actorPersistencePort;
    MatchingPersistencePort matchingPersistencePort;
    MovieCachePort movieCachePort;

    @BeforeEach
    void setUp() {
        moviePersistencePort = new StubMoviePersistence();
        actorPersistencePort = new StubActorPersistence();
        matchingPersistencePort = new StubMatchingPersistence();
        movieCachePort = new StubMovieCache();

        movieService = new MovieService(
                moviePersistencePort,
                actorPersistencePort,
                matchingPersistencePort,
                movieCachePort
        );
    }

    @Test
    void should_retrieve_movie_when_cache_is_exist() {
        //when
        Movie movie = movieService.retrieve(1L);

        //then
        assertThat(movie).isNotNull();
        assertThat(movie.getId()).isEqualTo(1L);
        assertThat(movie.getDirector()).isEqualTo("test director");
        assertThat(movie.getReleaseYear()).isEqualTo(2000);

        assertThat(((StubMoviePersistence) moviePersistencePort).interaction).isZero();
        assertThat(((StubMovieCache) movieCachePort).interaction).isEqualTo(1);
    }

    @Test
    void should_retrieve_movie_when_cache_empty() {
        //when
        Movie movie = movieService.retrieve(2L);

        //then
        assertThat(movie).isNotNull();
        assertThat(movie.getId()).isEqualTo(2L);
        assertThat(movie.getDirector()).isEqualTo("test director");
        assertThat(movie.getReleaseYear()).isEqualTo(2000);

        assertThat(((StubMoviePersistence) moviePersistencePort).interaction).isEqualTo(1);
        assertThat(((StubMovieCache) movieCachePort).interaction).isEqualTo(2);
    }
}