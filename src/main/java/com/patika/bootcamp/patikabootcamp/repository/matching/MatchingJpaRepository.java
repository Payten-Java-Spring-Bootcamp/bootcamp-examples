package com.patika.bootcamp.patikabootcamp.repository.matching;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingJpaRepository extends JpaRepository<MatchingEntity, Long> {

    List<MatchingEntity> findAllByMovie_Id(Long movieId);
}
