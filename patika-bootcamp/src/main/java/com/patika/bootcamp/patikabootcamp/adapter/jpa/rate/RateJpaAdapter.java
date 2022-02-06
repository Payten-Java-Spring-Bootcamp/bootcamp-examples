package com.patika.bootcamp.patikabootcamp.adapter.jpa.rate;

import com.patika.bootcamp.patikabootcamp.domain.port.RatePersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.rate.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateJpaAdapter implements RatePersistencePort {

    private final RateJpaRepository rateJpaRepository;

    @Override
    public void rateToMovie(Rate rate) {
        RateEntity rateEntity = new RateEntity();
        rateJpaRepository.save(rateEntity);
    }

    @Override
    public List<Rate> retrieveByMovieId(Long movieId) {
        return rateJpaRepository.retrieve(movieId)
                .stream()
                .map(RateEntity::toModel)
                .toList();
    }
}
