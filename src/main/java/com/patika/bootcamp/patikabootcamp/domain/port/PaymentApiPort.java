package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;

public interface PaymentApiPort {
    boolean validatePayment(Account account);
}
