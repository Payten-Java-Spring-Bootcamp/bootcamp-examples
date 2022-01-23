package com.patika.bootcamp.patikabootcamp.domain.movie;

import com.patika.bootcamp.patikabootcamp.adapter.rest.movie.MovieGenre;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Movie {

    private Long id;
    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;
}
