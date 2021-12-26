
package com.patika.bootcamp.patikabootcamp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class MemberRequest {

    @NotBlank
    private String name;

    @NotEmpty
    private List<Integer> deneme;
}
