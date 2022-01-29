package com.patika.bootcamp.patikabootcamp.domain.security;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import com.patika.bootcamp.patikabootcamp.domain.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatikaUserDetailService implements UserDetailsService {

    private final AccountPort accountPort;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Account appAccount = accountPort.retrieveByMail(mail);
        return new User(appAccount.getMail(), appAccount.getPassword(), List.of());
    }
}
