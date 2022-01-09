package com.patika.bootcamp.patikabootcamp.movie.repository;

public interface MovieDao {

    Long save(MovieEntity entity);

    MovieEntity retrieve(Long id);
}
