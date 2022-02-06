package com.patika.bootcamp.patikabootcamp.adapter.jpa.rate;

import com.patika.bootcamp.patikabootcamp.adapter.jpa.common.BaseEntity;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.movie.MovieEntity;
import com.patika.bootcamp.patikabootcamp.domain.rate.Rate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rateEntity")
@Table(name = "rate")
public class RateEntity extends BaseEntity {

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;

    public Rate toModel() {
        return Rate.builder()
                //todo map other field
                .build();
    }
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