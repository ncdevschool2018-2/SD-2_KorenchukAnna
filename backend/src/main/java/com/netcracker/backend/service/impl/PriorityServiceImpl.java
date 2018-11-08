package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.PrioritiesEntity;
import com.netcracker.backend.repository.PriorityRepository;
import com.netcracker.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriorityServiceImpl implements PriorityService {


    private PriorityRepository priorityRepository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository){
        this.priorityRepository = priorityRepository;
    }


    @Override
    public Iterable<PrioritiesEntity> getAllPriorities() {
        Iterable<PrioritiesEntity> priorities = priorityRepository.findAll();
        return priorities;
    }

    @Override
    public Optional<PrioritiesEntity> getPriorityById(long id) {
        Optional<PrioritiesEntity> priority = priorityRepository.findById(id);
        return priority;
    }



    @Override
    public PrioritiesEntity updatePriority(PrioritiesEntity priority) {
        return null;
    }

    @Override
    public PrioritiesEntity createPriority(PrioritiesEntity priority) {
        return null;
    }

    @Override
    public void deletePriorityById(long id) {

    }
}
