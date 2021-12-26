package com.patika.bootcamp.patikabootcamp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping("/members")
    public Set<MemberResponse> retrieveMembers(MemberResponse member) { //todo servis
        return Set.of(
                MemberResponse.builder()
                        .memberId(12L)
                        .name("mustafa")
                        .build(),
                MemberResponse.builder()
                        .memberId(17L)
                        .name("güneş")
                        .build()
        );
    }

    @GetMapping("/members/{memberId}")
    public MemberResponse retrieveMember(@PathVariable Long memberId) {
        return MemberResponse.builder()
                .memberId(memberId)
                .name("mustafa")
                .build();
    }

    @DeleteMapping("/members/{memberId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long memberId) {

    }

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createMember(@RequestBody @Valid MemberRequest request){
        return MemberResponse.builder()
                .name(request.getName())
                .memberId(12L)
                .build();
    }
}