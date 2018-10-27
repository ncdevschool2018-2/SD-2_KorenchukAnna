package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.AccountViewModel;
import com.netcracker.fapi.service.AccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountDataServiceImpl implements AccountDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<AccountViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] accounts = restTemplate.getForObject(backendServerUrl + "/backend/account",AccountViewModel[].class);
        return accounts == null  ? Collections.emptyList() :Arrays.asList(accounts);
    }


    @Override
    public AccountViewModel getAccountByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel account = restTemplate.getForObject(backendServerUrl + "/backend/account/"+login,AccountViewModel.class);
        return account;
    }

    @Override
    public AccountViewModel createAccount(AccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/backend/account", account, AccountViewModel.class).getBody();

    }

    @Override
    public AccountViewModel updateAccount(AccountViewModel account) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/backend/account/" + id);

    }
}
