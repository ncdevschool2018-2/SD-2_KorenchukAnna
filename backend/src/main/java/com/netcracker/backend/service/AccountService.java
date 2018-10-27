package com.netcracker.backend.service;

import com.netcracker.backend.entity.Account;

import java.util.Optional;


public interface AccountService {
    Account createAccount(Account user);
    Iterable<Account> getAllAccounts();
    Optional<Account> getAccountById(long id);
    Optional<Account> getAccountByLogin(String login);
    Account updateAccount(Account user);
    void deleteAccountById(long id);

}
