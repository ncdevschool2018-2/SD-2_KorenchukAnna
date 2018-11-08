package com.netcracker.fapi.service;

import com.netcracker.fapi.model.StatusViewModel;

import java.util.List;

public interface StatusDataService {
    List<StatusViewModel> getAll();
    StatusViewModel getStatusById(long id);
    void deleteStatus(long id);
}
