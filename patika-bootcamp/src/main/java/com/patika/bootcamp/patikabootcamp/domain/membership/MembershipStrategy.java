package com.patika.bootcamp.patikabootcamp.domain.membership;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MembershipStrategy {

    private final Map<String, Membership> strategyMap;

    public LocalDateTime calculateLastActivationDate(Account account) {
        return strategyMap.get(account.getMembership().getTypeName()).calculateLastActivationDate(account);
    }
}
