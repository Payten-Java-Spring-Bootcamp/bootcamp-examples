package com.patika.bootcamp.patikabootcamp.repository.movie;

import java.util.List;

public interface MovieDao {

    MovieEntity save(MovieEntity entity);

    MovieEntity retrieve(Long id);

    List<MovieEntity> retrieveByActorId(Long actorId);

    void delete(Long id);
}
