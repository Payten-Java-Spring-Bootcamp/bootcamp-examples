package com.patika.bootcamp.patikabootcamp.service.rate;

import java.util.List;

public interface RateService {

    void rateToMovie(Rate rate);

    List<Rate> retrieveByMovieId(Long movieId);

    List<Rate> retrieveByMovieIdV2(Long movieId);
}
