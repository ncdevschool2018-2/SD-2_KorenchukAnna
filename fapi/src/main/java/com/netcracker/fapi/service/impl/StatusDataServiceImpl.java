package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.StatusViewModel;
import com.netcracker.fapi.service.StatusDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusDataServiceImpl implements StatusDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<StatusViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StatusViewModel[] status = restTemplate.getForObject(backendServerUrl + "/backend/status/",StatusViewModel[].class);
        return Arrays.asList(status);
    }

    @Override
    public StatusViewModel getStatusById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        StatusViewModel status = restTemplate.getForObject(backendServerUrl + "/backend/status/"+id,StatusViewModel.class);
        return status;
    }

    @Override
    public void deleteStatus(long id) {

    }
}
