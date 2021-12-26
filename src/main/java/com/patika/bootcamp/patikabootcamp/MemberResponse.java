package com.patika.bootcamp.patikabootcamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberResponse {

    private Long memberId;
    private String name;
}
