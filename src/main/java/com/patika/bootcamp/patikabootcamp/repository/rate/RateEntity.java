package com.patika.bootcamp.patikabootcamp.repository.rate;

import com.patika.bootcamp.patikabootcamp.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rateEntity")
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}

//rate tablosu
//id=1;
//memberId=mustafa;
//movie=hp;
//point=5;
//
//id=2
//memberId=raşit
//movie=hp;
//point=4
//
//id=3
//memberId=isa
//movie=hp;
//point=3
//
//id=4
//memberId=mustafa
//movie=lotr;
//point=3