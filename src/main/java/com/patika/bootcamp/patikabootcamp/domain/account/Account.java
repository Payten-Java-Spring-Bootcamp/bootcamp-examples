package com.patika.bootcamp.patikabootcamp.domain.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {

    private Long id;
    private String mail;
    private String password;

    public void encodePassword(String password) {
        this.password = password;
    }
}
