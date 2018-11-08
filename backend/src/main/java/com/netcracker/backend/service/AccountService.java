package com.netcracker.backend.service;

import com.netcracker.backend.entity.AccountsEntity;

import java.util.Optional;


public interface AccountService {
    AccountsEntity createAccount(AccountsEntity user);
    Iterable<AccountsEntity> getAllAccounts();
    Optional<AccountsEntity> getAccountById(long id);
    Optional<AccountsEntity> getAccountByLogin(String login);
    AccountsEntity updateAccount(AccountsEntity user);
    void deleteAccountById(long id);

}
