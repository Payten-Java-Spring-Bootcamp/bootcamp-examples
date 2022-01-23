package com.patika.bootcamp.patikabootcamp.domain.movie;

import com.patika.bootcamp.patikabootcamp.domain.port.ActorPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MatchingPersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MovieCachePort;
import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTestWithMock {

    MovieService movieService;

    @Mock
    MoviePersistencePort moviePersistencePort;

    @Mock
    ActorPersistencePort actorPersistencePort;

    @Mock
    MatchingPersistencePort matchingPersistencePort;

    @Mock
    MovieCachePort movieCachePort;

    @BeforeEach
    void setUp() {
        movieService = new MovieService(
                moviePersistencePort,
                actorPersistencePort,
                matchingPersistencePort,
                movieCachePort
        );
    }

    @Test
    void should_retrieve_movie_when_cache_is_exist() {
        //mock
        Movie mockMovie = Movie.builder()
                .id(1L)
                .director("test director")
                .releaseYear(2000)
                .build();

        when(movieCachePort.retrieveMovie(1L)).thenReturn(mockMovie);

        //when
        Movie movie = movieService.retrieve(1L);

        //then
        assertThat(movie).isNotNull();
        assertThat(movie.getId()).isEqualTo(1L);
        assertThat(movie.getDirector()).isEqualTo("test director");
        assertThat(movie.getReleaseYear()).isEqualTo(2000);

        verifyNoInteractions(moviePersistencePort);
        verifyNoMoreInteractions(movieCachePort);
    }

    @Test
    void should_retrieve_movie_when_cache_empty() {
        //mock
        when(movieCachePort.retrieveMovie(any())).thenReturn(null);

        Movie mockMovie = Movie.builder()
                .id(1L)
                .director("test director")
                .releaseYear(2000)
                .build();

        when(moviePersistencePort.retrieve(1L)).thenReturn(mockMovie);
        doNothing().when(movieCachePort).createMovie(mockMovie);

        //when
        Movie movie = movieService.retrieve(1L);

        //then
        assertThat(movie).isNotNull();
        assertThat(movie.getId()).isEqualTo(1L);
        assertThat(movie.getDirector()).isEqualTo("test director");
        assertThat(movie.getReleaseYear()).isEqualTo(2000);
    }
}