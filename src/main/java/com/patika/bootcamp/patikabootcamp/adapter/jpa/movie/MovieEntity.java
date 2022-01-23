package com.patika.bootcamp.patikabootcamp.adapter.jpa.movie;

import com.patika.bootcamp.patikabootcamp.adapter.jpa.rate.RateEntity;
import com.patika.bootcamp.patikabootcamp.domain.movie.MovieGenre;
import com.patika.bootcamp.patikabootcamp.adapter.jpa.common.Status;
import com.patika.bootcamp.patikabootcamp.domain.movie.Movie;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
@Where(clause = "status <> 'DELETED'")
@EntityListeners(AuditingEntityListener.class)
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    private Integer releaseYear;

    @Column(nullable = false)
    private String director;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<RateEntity> rates;

    public static MovieEntity from(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setStatus(Status.ACTIVE);
        entity.setName(movie.getName());
        entity.setGenre(movie.getGenre());
        entity.setReleaseYear(movie.getReleaseYear());
        entity.setDirector(movie.getDirector());
        return entity;
    }

    public Movie toModel() {
        return Movie.builder()
                .id(id)
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }
}
