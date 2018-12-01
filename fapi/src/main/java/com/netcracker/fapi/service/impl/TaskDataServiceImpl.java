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
    public List<TaskViewModel> getAll(int page,int size) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] tasks = restTemplate.getForObject(backendServerUrl + "/backend/tasks?"+"page="+page+"&&"+"size="+size,TaskViewModel[].class);
        return Arrays.asList(tasks);
    }


    @Override
    public TaskViewModel getTaskByTaskCode(String taskCode) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel task = restTemplate.getForObject(backendServerUrl + "/backend/tasks/"+taskCode,TaskViewModel.class);
        return task;
    }

    @Override
    public TaskViewModel createTask(TaskViewModel task) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel ts = restTemplate.postForEntity(backendServerUrl + "/backend/tasks", task, TaskViewModel.class).getBody();
        System.out.print(ts);
        return ts;
    }

    @Override
    public long getCountOfTaskByProjectCode(String projectCode) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/backend/tasks/count/"+projectCode, Long.class);
    }

    @Override
    public void updateTask(TaskViewModel task) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendServerUrl + "/backend/tasks",task);
    }

    @Override
    public void deleteTask(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/backend/tasks/" + id);
    }
}
