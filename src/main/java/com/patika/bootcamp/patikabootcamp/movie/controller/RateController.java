package com.patika.bootcamp.patikabootcamp.movie.controller;

import com.patika.bootcamp.patikabootcamp.movie.controller.request.RateRequest;
import com.patika.bootcamp.patikabootcamp.movie.controller.response.RateResponse;
import com.patika.bootcamp.patikabootcamp.movie.service.Movie;
import com.patika.bootcamp.patikabootcamp.movie.service.Rate;
import com.patika.bootcamp.patikabootcamp.movie.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping("/rates")
    public void rate(@RequestBody @Valid RateRequest rateRequest) {
        Rate rate = rateRequest.convertToRate();
        rateService.rateToMovie(rate);
    }

    @GetMapping("/rates")
    public List<RateResponse> retrieveByMovieId(@RequestParam Long movieId) {
        List<Rate> rateList = rateService.retrieveByMovieId(movieId);
        return RateResponse.convertFromRate(rateList);
    }
}
