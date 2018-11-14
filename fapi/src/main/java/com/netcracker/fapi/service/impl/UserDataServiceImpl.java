package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.UserViewModel;
import com.netcracker.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] users = restTemplate.getForObject(backendServerUrl + "/backend/users/",UserViewModel[].class);
        return Arrays.asList(users);
    }

    @Override
    public UserViewModel getUserById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel account = restTemplate.getForObject(backendServerUrl + "/backend/users/id/" + id,UserViewModel.class);
        return account;
    }

    @Override
    public UserViewModel getUserByAccountId(long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel account = restTemplate.getForObject(backendServerUrl + "/backend/users/accountId/" + id,UserViewModel.class);
        return account;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public UserViewModel createUser(UserViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/backend/users", user, UserViewModel.class).getBody();
    }
}
