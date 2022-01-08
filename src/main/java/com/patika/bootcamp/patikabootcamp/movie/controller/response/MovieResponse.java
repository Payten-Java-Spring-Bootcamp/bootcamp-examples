package com.patika.bootcamp.patikabootcamp.movie.controller.response;

import com.patika.bootcamp.patikabootcamp.movie.MovieGenre;
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
    private List<CastResponse> castList;
}
