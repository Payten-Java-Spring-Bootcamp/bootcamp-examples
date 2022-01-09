package com.patika.bootcamp.patikabootcamp.movie.controller;

import com.patika.bootcamp.patikabootcamp.movie.controller.request.MovieRequest;
import com.patika.bootcamp.patikabootcamp.movie.controller.response.MovieCreateResponse;
import com.patika.bootcamp.patikabootcamp.movie.controller.response.MovieResponse;
import com.patika.bootcamp.patikabootcamp.movie.service.Movie;
import com.patika.bootcamp.patikabootcamp.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse create(@RequestBody @Valid MovieRequest request) {
        Movie movie = request.convertToMovie();
        Long id = movieService.create(movie);
        return MovieCreateResponse.convertToMovieResponse(id);
    }

    @GetMapping("/movies/{id}")
    public MovieResponse retrieve(@PathVariable Long id) {
        Movie movie = movieService.retrieve(id);
        return MovieResponse.convertFrom(movie);
    }
}
