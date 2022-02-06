package com.patika.bootcamp.patikabootcamp.domain.membership;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import com.patika.bootcamp.patikabootcamp.domain.port.MailApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service(MembershipType.Name.STUDENT)
@RequiredArgsConstructor
public class StudentMembership implements Membership {

    private final MailApiPort mailApiPort;

    @Override
    public LocalDateTime calculateLastActivationDate(Account account) {
        mailApiPort.sendActivationMail(account.getMail(), "Lütfen başvurunuzu onaylayınız");
        return LocalDateTime.now().plusMonths(3);
    }
}
