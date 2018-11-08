package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.AccountsEntity;
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


    public AccountsEntity createAccount(AccountsEntity user) {
        AccountsEntity account = accountRepository.save(user);
        return account;
    }


    public Iterable<AccountsEntity> getAllAccounts() {
        Iterable<AccountsEntity> accounts = accountRepository.findAll();
        return accounts;
    }

    public Optional<AccountsEntity> getAccountById(long id) {
        Optional<AccountsEntity> account = accountRepository.findById(id);
        return account;
    }

    @Override
    public Optional<AccountsEntity> getAccountByLogin(String login) {
        Optional<AccountsEntity> account = accountRepository.findAccountByLogin(login);
        return account;
    }

    public AccountsEntity updateAccount(AccountsEntity user) {
        return null;
    }

    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }
}
