package com.patika.bootcamp.patikabootcamp.lomboktraining;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    private String name;

    @EqualsAndHashCode.Include
    private Integer number;

}
