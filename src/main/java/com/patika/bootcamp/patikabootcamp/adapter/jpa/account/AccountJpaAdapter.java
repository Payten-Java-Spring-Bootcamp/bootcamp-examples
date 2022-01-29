package com.patika.bootcamp.patikabootcamp.adapter.jpa.account;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import com.patika.bootcamp.patikabootcamp.domain.exception.ExceptionType;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaDataNotFoundException;
import com.patika.bootcamp.patikabootcamp.domain.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountJpaAdapter implements AccountPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account retrieveByMail(String mail) {
        return accountJpaRepository.findByMail(mail)
                .orElseThrow(() -> new PatikaDataNotFoundException(ExceptionType.MAIL_NOT_FOUND))
                .toModel();
    }

    @Override
    public Account create(Account account) {
        AccountEntity accountEntity = AccountEntity.from(account);
        return accountJpaRepository.save(accountEntity).toModel();
    }

    @Override
    public Account retrieve(Long id) {
        return retrieveUserEntity(id)
                .toModel();
    }

    @Override
    public Boolean isMailExists(String mail) {
        return accountJpaRepository.existsByMail(mail);
    }

    private AccountEntity retrieveUserEntity(Long id) {
        return accountJpaRepository.findById(id)
                .orElseThrow(() -> new PatikaDataNotFoundException(ExceptionType.ACCOUNT_NOT_FOUND));
    }
}
