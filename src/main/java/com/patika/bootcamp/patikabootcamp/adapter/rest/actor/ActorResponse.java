package com.patika.bootcamp.patikabootcamp.adapter.rest.actor;

import com.patika.bootcamp.patikabootcamp.domain.actor.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorResponse {

    private Long id;
    private String name;
    private LocalDateTime birthDate;

    public static List<ActorResponse> from(List<Actor> actors) {
        return actors.stream()
                .map(ActorResponse::from)
                .toList();
    }

    private static ActorResponse from(Actor actor) {
        return ActorResponse.builder()
                .id(actor.getId())
                .name(actor.getName())
                .birthDate(actor.getBirthDate())
                .build();
    }
}
