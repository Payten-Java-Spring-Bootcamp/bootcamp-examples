package com.patika.bootcamp.patikabootcamp.adapter.api;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import com.patika.bootcamp.patikabootcamp.domain.port.PaymentApiPort;
import org.springframework.stereotype.Service;

@Service
public class PaymentAdapter implements PaymentApiPort {

    @Override
    public boolean validatePayment(Account account) {
        return true;
    }
}
