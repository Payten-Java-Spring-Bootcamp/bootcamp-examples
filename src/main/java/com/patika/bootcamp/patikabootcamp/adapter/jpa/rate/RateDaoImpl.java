package com.patika.bootcamp.patikabootcamp.adapter.jpa.rate;

import com.patika.bootcamp.patikabootcamp.domain.port.RatePersistencePort;
import com.patika.bootcamp.patikabootcamp.domain.rate.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateDaoImpl implements RatePersistencePort {

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
