package com.patika.bootcamp.patikabootcamp.repository.matching;

import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchingDaoImpl implements MatchingDao {

    private final MatchingJpaRepository matchingJpaRepository;

    @Override
    public void create(List<MatchingEntity> matchingEntityList) {
        matchingJpaRepository.saveAll(matchingEntityList);
    }

    @Override
    public List<ActorEntity> retrieveActorsByMovieId(Long movieId) {
        return matchingJpaRepository.findAllByMovie_Id(movieId)
                .stream()
                .map(MatchingEntity::getActor)
                .toList();
    }
}
