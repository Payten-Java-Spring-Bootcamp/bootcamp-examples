package com.patika.bootcamp.patikabootcamp.adapter.rest.account;

import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import com.patika.bootcamp.patikabootcamp.domain.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse create(@Valid @RequestBody SignUpRequest request) {
        Account account = accountService.createAccount(request.toModel());
        return AccountResponse.from(account);
    }

    @GetMapping("/accounts/{id}")
    public AccountResponse retrieve(@PathVariable Long id) {
        Account account = accountService.retrieve(id);
        return AccountResponse.from(account);
    }
}
