package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.PriorityViewModel;
import com.netcracker.fapi.service.PriorityDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PriorityDataServiceImpl implements PriorityDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<PriorityViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        PriorityViewModel[] priorities = restTemplate.getForObject(backendServerUrl + "/backend/priority/",PriorityViewModel[].class);
        return Arrays.asList(priorities);
    }

    @Override
    public PriorityViewModel getPriorityById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        PriorityViewModel priority = restTemplate.getForObject(backendServerUrl + "/backend/priority/"+id,PriorityViewModel.class);
        return priority;
    }


    @Override
    public void deletePriority(long id) {

    }
}
