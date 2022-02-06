package com.patika.bootcamp.patikabootcamp.adapter.jpa.actor;

import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import com.patika.bootcamp.patikabootcamp.domain.port.ActorPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorJpaAdapter implements ActorPersistencePort {

    private final ActorJpaRepository actorJpaRepository;

    @Override
    public Long create(Actor actor) {
        ActorEntity createdActor = actorJpaRepository.save(ActorEntity.from(actor));
        return createdActor.getId();
    }

    @Override
    public List<Actor> create(List<Actor> actors) {
        List<ActorEntity> actorEntities = actors.stream()
                .map(ActorEntity::from)
                .toList();

        return actorJpaRepository.saveAll(actorEntities)
                .stream()
                .map(ActorEntity::toModel)
                .toList();
    }

    @Override
    public List<Actor> retrieve(List<Long> actorIds) {
        return actorJpaRepository.findAllByIdIn(actorIds)
                .stream()
                .map(ActorEntity::toModel)
                .toList();
    }
}
