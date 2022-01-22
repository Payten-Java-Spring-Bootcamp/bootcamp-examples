package com.patika.bootcamp.patikabootcamp.controller.movie;

import com.patika.bootcamp.patikabootcamp.controller.actor.ActorResponse;
import com.patika.bootcamp.patikabootcamp.service.actor.Actor;
import com.patika.bootcamp.patikabootcamp.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieResponse {

    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;
    private List<ActorResponse> actors;

    public static MovieResponse convertFrom(Movie movie) {
        return MovieResponse.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .build();
    }

    public static MovieResponse convertFrom(Movie movie, List<Actor> actors) {
        return MovieResponse.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .actors(ActorResponse.from(actors))
                .build();
    }
}
