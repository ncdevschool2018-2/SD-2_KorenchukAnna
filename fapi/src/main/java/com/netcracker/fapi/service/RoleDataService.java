package com.netcracker.fapi.service;

import com.netcracker.fapi.model.RoleViewModel;

import java.util.List;

public interface RoleDataService {

    List<RoleViewModel> getAll();
    RoleViewModel getRoleById(long id);
}
