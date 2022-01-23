package com.patika.bootcamp.patikabootcamp.repository.movie;

import com.patika.bootcamp.patikabootcamp.repository.Status;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorEntity;
import com.patika.bootcamp.patikabootcamp.repository.actor.ActorJpaRepository;
import com.patika.bootcamp.patikabootcamp.repository.matching.MatchingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final MovieJpaRepository movieJpaRepository;
    private final ActorJpaRepository actorJpaRepository;

    @Override
    public MovieEntity save(MovieEntity entity) {
        return movieJpaRepository.save(entity);
    }

    @Override
    public MovieEntity retrieve(Long id) {
        Optional<MovieEntity> movieEntityOptional = movieJpaRepository.findById(id);

        if (movieEntityOptional.isPresent())
            return movieEntityOptional.get();
        else
            throw new RuntimeException();
    }

    @Override
    public List<MovieEntity> retrieveByActorId(Long actorId) {
        Optional<ActorEntity> actorEntityOptional = actorJpaRepository.findById(actorId);

        if (actorEntityOptional.isPresent())
            return actorEntityOptional.get()
                    .getMatchings()
                    .stream()
                    .map(MatchingEntity::getMovie)
                    .toList();
        else
            throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        Optional<MovieEntity> optionalMovieEntity = movieJpaRepository.findById(id);

        if(optionalMovieEntity.isPresent()) {
            MovieEntity entity = optionalMovieEntity.get();
            entity.setStatus(Status.DELETED);
            movieJpaRepository.save(entity);
        }
    }
}
