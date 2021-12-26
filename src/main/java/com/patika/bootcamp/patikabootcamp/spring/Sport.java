package com.patika.bootcamp.patikabootcamp.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Primary
public class Sport {

    private String sportName = "default sport name";

    @Bean
    public Sport football() {
        Sport sport = new Sport();
        sport.sportName = "name is football";
        return sport;
    }

    @Bean("tennisSport")
    public Sport tennis() {
        Sport sport = new Sport();
        sport.sportName = "name tennis";
        return sport;
    }

    @Bean("lotr")
    public Movie lotr() {
        Movie movie = new Movie();
        movie.setMovieName("lotr name");
        return movie;
    }
}
