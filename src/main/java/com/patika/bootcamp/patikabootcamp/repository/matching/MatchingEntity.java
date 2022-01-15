package com.patika.bootcamp.patikabootcamp.repository.matching;

import com.patika.bootcamp.patikabootcamp.repository.movie.MovieEntity;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "matching")
@Table(name = "matching")
public class MatchingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MovieEntity movieEntity;

    @ManyToOne
    private ActorEntity actorEntity;
}
