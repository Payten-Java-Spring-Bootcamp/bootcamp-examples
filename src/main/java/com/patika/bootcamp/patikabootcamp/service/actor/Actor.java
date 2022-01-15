package com.patika.bootcamp.patikabootcamp.service.actor;

import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
public class Actor implements Serializable {

    private Long id;
    private String name;
    private LocalDateTime birthDate;

    public ActorEntity convertToActorEntity() {
        ActorEntity entity = new ActorEntity();
        entity.setName(name);
        entity.setBirthDate(birthDate);
        return entity;
    }
}
