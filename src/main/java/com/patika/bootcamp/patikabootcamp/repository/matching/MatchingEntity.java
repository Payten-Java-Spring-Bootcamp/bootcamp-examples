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
    private MovieEntity movie;

    @ManyToOne
    private ActorEntity actor;
}

/*
user
user id, email, name, surname, city, twitter address, phone number,snapchat


communication
user_id, email, twitter address, phone number, github address


communication
user id, communication type, communication address, status
1, twitter address, mgunes17, 0
1, phone numbr ı , 9010010010
1, email, mustafa@gmail

 */