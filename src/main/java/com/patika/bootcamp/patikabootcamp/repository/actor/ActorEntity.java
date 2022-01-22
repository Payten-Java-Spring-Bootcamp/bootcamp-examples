package com.patika.bootcamp.patikabootcamp.repository.actor;

import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingEntity;
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
}
