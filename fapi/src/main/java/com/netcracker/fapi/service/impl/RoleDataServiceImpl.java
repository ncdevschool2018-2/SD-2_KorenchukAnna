package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.RoleViewModel;
import com.netcracker.fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleDataServiceImpl implements RoleDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<RoleViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        RoleViewModel[] rolies = restTemplate.getForObject(backendServerUrl + "/backend/role/", RoleViewModel[].class);
        return Arrays.asList(rolies);
    }

    @Override
    public RoleViewModel getRoleById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        RoleViewModel role = restTemplate.getForObject(backendServerUrl + "/backend/role/"+id, RoleViewModel.class);
        return role;
    }
}
