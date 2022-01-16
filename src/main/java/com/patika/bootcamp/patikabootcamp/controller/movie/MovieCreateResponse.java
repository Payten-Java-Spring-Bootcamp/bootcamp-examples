package com.patika.bootcamp.patikabootcamp.controller.movie;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateResponse {

    private Long id;

    public static MovieCreateResponse convertToMovieResponse(Long id) {
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
