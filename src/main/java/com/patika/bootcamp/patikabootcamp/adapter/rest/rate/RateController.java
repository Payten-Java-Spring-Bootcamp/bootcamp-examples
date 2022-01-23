package com.patika.bootcamp.patikabootcamp.adapter.rest.rate;

import com.patika.bootcamp.patikabootcamp.domain.rate.Rate;
import com.patika.bootcamp.patikabootcamp.domain.rate.RateService;
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
