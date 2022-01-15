package com.patika.bootcamp.patikabootcamp.controller.movie;

import com.patika.bootcamp.patikabootcamp.controller.actor.ActorCreateRequest;
import com.patika.bootcamp.patikabootcamp.service.actor.Actor;
import com.patika.bootcamp.patikabootcamp.service.movie.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Data
public class MovieRequest {

    @NotBlank
    private String name;

    @NotNull
    private MovieGenre genre;

    @NotNull
    private Integer releaseYear;

    @NotNull
    private String director;

    private List<ActorCreateRequest> actors;
    private List<Long> actorIds;

    public Movie convertToMovie() {
        return Movie.builder()
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }

    public List<Actor> convertToActors() {
        if (CollectionUtils.isEmpty(actors))
            return new ArrayList<>();

        return actors.stream()
                .map(ActorCreateRequest::convertToActor)
                .collect(Collectors.toList());
    }
}
