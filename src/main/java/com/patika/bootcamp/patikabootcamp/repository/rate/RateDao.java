package com.patika.bootcamp.patikabootcamp.repository.rate;

import java.util.List;

public interface RateDao {

    void rateToMovie(RateEntity entity);

    List<RateEntity> retrieveByMovieId(Long movieId);
}
