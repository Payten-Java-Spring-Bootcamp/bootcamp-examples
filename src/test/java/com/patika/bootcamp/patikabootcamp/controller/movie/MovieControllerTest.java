package com.patika.bootcamp.patikabootcamp.controller.movie;

import com.patika.bootcamp.patikabootcamp.BaseIntegrationTest;
import com.patika.bootcamp.patikabootcamp.controller.actor.ActorCreateRequest;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorJpaRepository;
import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingEntity;
import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingJpaRepository;
import com.patika.bootcamp.patikabootcamp.repository.movie.MovieEntity;
import com.patika.bootcamp.patikabootcamp.repository.movie.MovieJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

class MovieControllerTest extends BaseIntegrationTest {

    @Autowired
    MovieJpaRepository movieJpaRepository;

    @Autowired
    ActorJpaRepository actorJpaRepository;

    @Autowired
    MatchingJpaRepository matchingJpaRepository;

    @Test
    @Sql(scripts = "/actor-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_movie_with_actors_in_db_and_new_actors() {
        //given
        MovieRequest request = new MovieRequest();
        request.setName("test movie name");
        request.setGenre(MovieGenre.ACTION);
        request.setReleaseYear(2008);
        request.setDirector("test director");

        ActorCreateRequest actorCreateRequest1 = new ActorCreateRequest();
        actorCreateRequest1.setName("actor name 1");
        actorCreateRequest1.setBirthDate(LocalDateTime.of(2000, 1, 12, 14, 0));

        ActorCreateRequest actorCreateRequest2 = new ActorCreateRequest();
        actorCreateRequest2.setName("actor name 2");
        actorCreateRequest2.setBirthDate(LocalDateTime.of(1990, 1, 12, 14, 0));

        request.setActors(List.of(actorCreateRequest1, actorCreateRequest2));
        request.setActorIds(List.of(1001L, 1002L, 1003L));

        //when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/movies", request, MovieCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        //validate movie
        Optional<MovieEntity> movie = movieJpaRepository.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get().getName()).isEqualTo("test movie name");
        //todo validate other movie fields

        //validate actor
        List<ActorEntity> actors = actorJpaRepository.findAll();
        assertThat(actors)
                .hasSize(5)
                .extracting("name", "birthDate")
                .contains(
                        tuple("actor name 1", LocalDateTime.of(2000, 1, 12, 14, 0)),
                        tuple("actor name 2", LocalDateTime.of(1990, 1, 12, 14, 0))
                );

        //validate matching
        List<MatchingEntity> matchings = matchingJpaRepository.findAll();
        assertThat(matchings).hasSize(5);
    }

    @Test
    @Sql(scripts = "/movie-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_retrieve_movie() {
        //when
        ResponseEntity<MovieResponse> response = testRestTemplate.getForEntity("/movies/1001", MovieResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        assertThat(response.getBody())
                .extracting("name", "genre", "releaseYear", "director")
                .containsExactly("test film 1001", MovieGenre.COMEDY, 2001, "test yönetmen 1001");

        assertThat(response.getBody().getActors())
                .hasSize(2)
                .extracting("id", "name", "birthDate")
                .containsExactly(
                        tuple(2001L, "test actor 2001", LocalDateTime.of(2001, 1, 12, 11, 0, 0)),
                        tuple(2003L, "test actor 2003", LocalDateTime.of(2003, 1, 12, 13, 0, 0))
                );
    }
}