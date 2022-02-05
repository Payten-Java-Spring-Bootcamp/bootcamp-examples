package com.patika.bootcamp.patikabootcamp.domain.account;

import com.patika.bootcamp.patikabootcamp.domain.exception.ExceptionType;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaValidationException;
import com.patika.bootcamp.patikabootcamp.domain.membership.Membership;
import com.patika.bootcamp.patikabootcamp.domain.membership.MembershipStrategy;
import com.patika.bootcamp.patikabootcamp.domain.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountPort accountPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MembershipStrategy membershipStrategy;

    public Account createAccount(Account account) {
        if (Boolean.TRUE.equals(accountPort.isMailExists(account.getMail())))
            throw new PatikaValidationException(ExceptionType.MAIL_EXISTS);

        account.encodePassword(bCryptPasswordEncoder.encode(account.getPassword()));
        updateLastActivationDate(account);
        return accountPort.create(account);
    }

    private void updateLastActivationDate(Account account) {
        LocalDateTime dateTime = membershipStrategy.calculateLastActivationDate(account);
        LocalDateTime calculate = account.getMembership().calculate();
        account.setLastActivationDate(dateTime);
    }

    public Account retrieve(Long id) {
        return accountPort.retrieve(id);
    }
}
