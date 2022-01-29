package com.patika.bootcamp.patikabootcamp.domain.account;

import com.patika.bootcamp.patikabootcamp.domain.exception.ExceptionType;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaValidationException;
import com.patika.bootcamp.patikabootcamp.domain.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountPort accountPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Account createAccount(Account account) {
        if (accountPort.isMailExists(account.getMail()))
            throw new PatikaValidationException(ExceptionType.MAIL_EXISTS);

        account.encodePassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountPort.create(account);
    }

    public Account retrieve(Long id) {
        return accountPort.retrieve(id);
    }
}
