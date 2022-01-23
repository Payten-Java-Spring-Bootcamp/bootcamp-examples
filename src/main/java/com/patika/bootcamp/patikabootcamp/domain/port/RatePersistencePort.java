package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.rate.Rate;

import java.util.List;

public interface RatePersistencePort {

    void rateToMovie(Rate entity);

    List<Rate> retrieveByMovieId(Long movieId);
}
