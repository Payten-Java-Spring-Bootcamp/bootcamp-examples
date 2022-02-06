package com.patika.bootcamp.patikabootcamp.domain.port;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;

public interface AccountPort {

    Account retrieveByMail(String mail);

    Account create(Account account);

    Account retrieve(Long id);

    Boolean isMailExists(String mail);
}
