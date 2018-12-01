package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.StatusEntity;
import com.netcracker.backend.repository.StatusRepository;
import com.netcracker.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @Override
    public Iterable<StatusEntity> getAllStatus() {
        Iterable<StatusEntity> status = statusRepository.findAll();
        return status;
    }

    @Override
    public Optional<StatusEntity> getStatusById(long id) {
        Optional<StatusEntity> status = statusRepository.findById(id);
        return status;
    }


    @Override
    public StatusEntity createStatus(StatusEntity status) {
        return null;
    }

    @Override
    public StatusEntity updateStatus(StatusEntity status) {
        return null;
    }

    @Override
    public void deleteStatusById(long id) {
        statusRepository.deleteById(id);
    }
}
