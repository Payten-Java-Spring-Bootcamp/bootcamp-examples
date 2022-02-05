package com.patika.bootcamp.patikabootcamp.domain.membership;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;

import java.time.LocalDateTime;

public interface Membership {

    LocalDateTime calculateLastActivationDate(Account account);
}
