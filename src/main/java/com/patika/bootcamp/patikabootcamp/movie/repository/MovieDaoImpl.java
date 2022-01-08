package com.patika.bootcamp.patikabootcamp.movie.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final MovieJpaRepository movieJpaRepository;

    @Override
    public Long save(MovieEntity entity) {
        MovieEntity savedEntity = movieJpaRepository.save(entity);
        return savedEntity.getId();
    }
}
