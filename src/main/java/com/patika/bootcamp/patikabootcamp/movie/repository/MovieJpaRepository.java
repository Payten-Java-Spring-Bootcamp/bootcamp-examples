package com.patika.bootcamp.patikabootcamp.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
