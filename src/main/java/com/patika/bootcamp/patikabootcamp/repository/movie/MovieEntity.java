package com.patika.bootcamp.patikabootcamp.repository.movie;

import com.patika.bootcamp.patikabootcamp.controller.movie.MovieGenre;
import com.patika.bootcamp.patikabootcamp.repository.rate.RateEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    private Integer releaseYear;

    @Column(nullable = false)
    private String director;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<RateEntity> rates;
}
