package com.patika.bootcamp.patikabootcamp.movie.service;

import com.patika.bootcamp.patikabootcamp.movie.repository.MovieDao;
import com.patika.bootcamp.patikabootcamp.movie.repository.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Override
    public Long create(Movie movie) {
        MovieEntity movieEntity = movie.convertToMovieEntity();
        return movieDao.save(movieEntity);
    }

}
