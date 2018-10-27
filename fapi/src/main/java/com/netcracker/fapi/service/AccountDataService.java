package com.netcracker.fapi.service;

import com.netcracker.fapi.model.AccountViewModel;

import java.util.List;

public interface AccountDataService {
    List<AccountViewModel> getAll();
    AccountViewModel getAccountByLogin(String login);
    AccountViewModel createAccount(AccountViewModel account);
    AccountViewModel updateAccount(AccountViewModel account);
    void deleteAccount(Long id);
}
