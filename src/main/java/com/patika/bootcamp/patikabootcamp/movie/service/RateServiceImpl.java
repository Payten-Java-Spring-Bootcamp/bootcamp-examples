package com.patika.bootcamp.patikabootcamp.movie.service;

import com.patika.bootcamp.patikabootcamp.movie.repository.MovieDao;
import com.patika.bootcamp.patikabootcamp.movie.repository.MovieEntity;
import com.patika.bootcamp.patikabootcamp.movie.repository.RateDao;
import com.patika.bootcamp.patikabootcamp.movie.repository.RateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateDao rateDao;
    private final MovieDao movieDao;

    @Override
    public void rateToMovie(Rate rate) {
        MovieEntity movieEntity = movieDao.retrieve(rate.getMovieId());
        RateEntity entity = rate.convertToRateEntity(movieEntity);
        rateDao.rateToMovie(entity);
    }

    @Override
    public List<Rate> retrieveByMovieIdV2(Long movieId) {
        return movieDao.retrieve(movieId)
                .getRates()
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rate> retrieveByMovieId(Long movieId) {
        return rateDao.retrieveByMovieId(movieId)
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());
    }
}
