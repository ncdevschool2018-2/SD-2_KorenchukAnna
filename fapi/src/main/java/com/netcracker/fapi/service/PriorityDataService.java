package com.netcracker.fapi.service;

import com.netcracker.fapi.model.PriorityViewModel;

import java.util.List;

public interface PriorityDataService {

    List<PriorityViewModel> getAll();
    PriorityViewModel getPriorityById(long id);
    void deletePriority(long id);

}
