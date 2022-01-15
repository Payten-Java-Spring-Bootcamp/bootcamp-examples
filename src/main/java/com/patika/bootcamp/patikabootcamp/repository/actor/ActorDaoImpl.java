package com.patika.bootcamp.patikabootcamp.repository.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao {

    private final ActorJpaRepository actorJpaRepository;

    @Override
    public Long create(ActorEntity actorEntity) {
        ActorEntity createdActor = actorJpaRepository.save(actorEntity);
        return createdActor.getId();
    }

    @Override
    public List<ActorEntity> create(List<ActorEntity> actors) {
        return actorJpaRepository.saveAll(actors);
    }

    @Override
    public List<ActorEntity> retrieve(List<Long> actorIds) {
        return actorJpaRepository.findAllByIdIn(actorIds);
    }
}
