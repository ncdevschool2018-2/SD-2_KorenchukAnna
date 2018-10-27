package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.Account;
import com.netcracker.backend.repository.AccountRepository;
import com.netcracker.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }


    public Account createAccount(Account user) {
        Account account = accountRepository.save(user);
        return account;
    }


    public Iterable<Account> getAllAccounts() {
        Iterable<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    public Optional<Account> getAccountById(long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account;
    }

    @Override
    public Optional<Account> getAccountByLogin(String login) {
        Optional<Account> account = accountRepository.findAccountByLogin(login);
        return account;
    }

    public Account updateAccount(Account user) {
        return null;
    }

    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }
}
