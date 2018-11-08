package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.TaskViewModel;
import com.netcracker.fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskDataServiceImpl implements TaskDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<TaskViewModel> getAll() {

        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] tasks = restTemplate.getForObject(backendServerUrl + "/backend/tasks/",TaskViewModel[].class);
        return Arrays.asList(tasks);
    }




    @Override
    public TaskViewModel getTaskByTaskCode(String taskCode) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel task = restTemplate.getForObject(backendServerUrl + "/backend/tasks/"+taskCode,TaskViewModel.class);
        return task;
    }

    @Override
    public void deleteTask(Long id) {

    }
}
