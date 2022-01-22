package com.patika.bootcamp.patikabootcamp.service.movie;

import com.patika.bootcamp.patikabootcamp.controller.movie.MovieGenre;
import com.patika.bootcamp.patikabootcamp.repository.movie.MovieEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Movie implements Serializable {

    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;

    MovieEntity convertToMovieEntity() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(getName());
        movieEntity.setDirector(getDirector());
        movieEntity.setReleaseYear(getReleaseYear());
        movieEntity.setGenre(getGenre());
        return movieEntity;
    }

    public static Movie convertFrom(MovieEntity entity) {
        return Movie.builder()
                .name(entity.getName())
                .genre(entity.getGenre())
                .releaseYear(entity.getReleaseYear())
                .director(entity.getDirector())
                .build();
    }
}
