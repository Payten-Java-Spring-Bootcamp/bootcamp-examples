package com.patika.bootcamp.patikabootcamp.spring;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value = "prototype")
@ToString(exclude = "releaseYear")
public class Movie {

    @JsonProperty("name")
    private String movieName = "default movie name";

    @JsonIgnore
    private Integer releaseYear;

    @Bean("nbc")
    public Movie nbcMovie() {
        Movie movie = new Movie();
        movie.movieName = "kış uykusu";
        return movie;
    }

    @Bean("hp")
    public Movie hpMovie() {
        Movie movie = new Movie();
        movie.movieName = "felsefe taşı";
        movie.releaseYear = 2000;
        return movie;
    }
}
