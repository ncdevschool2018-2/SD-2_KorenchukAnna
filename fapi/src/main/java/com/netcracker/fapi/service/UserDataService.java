package com.netcracker.fapi.service;

import com.netcracker.fapi.model.UserViewModel;

import java.util.List;

public interface UserDataService {

    List<UserViewModel> getAll();
    UserViewModel getUserById(long id);
    UserViewModel getUserByAccountId(long id);
    UserViewModel createUser(UserViewModel user);
    void deleteUser(long id);
}
