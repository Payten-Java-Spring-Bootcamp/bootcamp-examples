package com.patika.bootcamp.patikabootcamp.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
