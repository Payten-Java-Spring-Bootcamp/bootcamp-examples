package com.patika.bootcamp.patikabootcamp.repository.actor;

import java.util.List;

public interface ActorDao {

    Long create(ActorEntity actor);

    List<ActorEntity> create(List<ActorEntity> actors);

    List<ActorEntity> retrieve(List<Long> actorIds);
}
