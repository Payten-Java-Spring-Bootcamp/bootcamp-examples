package com.patika.bootcamp.patikabootcamp.adapter.jpa.actor;

import com.patika.bootcamp.patikabootcamp.adapter.jpa.matching.MatchingEntity;
import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "actor")
@Table(name = "actor")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "actor")
    private List<MatchingEntity> matchings;

    public static ActorEntity from(Actor actor) {
        ActorEntity entity = new ActorEntity();
        entity.setName(actor.getName());
        entity.setBirthDate(actor.getBirthDate());
        return entity;
    }

    public Actor toModel() {
        return Actor.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}
