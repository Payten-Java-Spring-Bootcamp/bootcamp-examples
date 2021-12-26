package com.patika.bootcamp.patikabootcamp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patika.bootcamp.patikabootcamp.spring.Movie;
import com.patika.bootcamp.patikabootcamp.spring.SpringMain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JsonMain {

    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMain.class);

        Movie hpMovie = (Movie) context.getBean("hp");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(hpMovie);

        System.out.println(s);
        System.out.println(hpMovie);

        String s1 = "{\"name\":\"felsefe taşı\"}";
        Movie movie = objectMapper.readValue(s1, Movie.class);
        System.out.println(movie.getMovieName());
    }
}
