package com.netcracker.backend.controller;

import com.netcracker.backend.entity.Account;
import com.netcracker.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/backend/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    AccountController( AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account) {
        return  accountService.createAccount(account);
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Optional<Account> account = accountService.getAccountById(id);
        if(account.isPresent())
            return ResponseEntity.ok().body(account.get());
        else
            return ResponseEntity.noContent().build();

    }*/

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountByLogin(@PathVariable(name = "login") String login) {
        Optional<Account> account = accountService.getAccountByLogin(login);
        if(account.isPresent())
            return ResponseEntity.ok().body(account.get());
        else
            return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Account> getAllAcounts() {
        return accountService.getAllAccounts();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccountById(@PathVariable(name="id") Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }


}
