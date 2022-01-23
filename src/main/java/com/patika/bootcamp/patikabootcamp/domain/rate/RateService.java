package com.patika.bootcamp.patikabootcamp.domain.rate;

import com.patika.bootcamp.patikabootcamp.domain.port.MoviePersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.port.RatePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RatePersistencePort ratePersistencePort;
    private final MoviePersistencePort moviePersistencePort;

    public void rateToMovie(Rate rate) {
        ratePersistencePort.rateToMovie(rate);
    }

    public List<Rate> retrieveByMovieIdV2(Long movieId) {
        //todo refactor via hexagonal
        return null;
        /*
        return moviePersistencePort.retrieve(movieId)
                .getRates()
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());

         */
    }

    public List<Rate> retrieveByMovieId(Long movieId) {
        //todo refactor via hexagonal
        return null;
        /*
        return ratePersistencePort.retrieveByMovieId(movieId)
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());

         */
    }
}
