package com.netcracker.backend.service;

import com.netcracker.backend.entity.UsersEntity;

import java.util.Optional;

public interface UserService {
    UsersEntity createUser(UsersEntity user);
    Iterable<UsersEntity> getAllUsers();
    Optional<UsersEntity> getUserById(long id);
    UsersEntity updateAccount(UsersEntity user);
    void deleteUser(long id);

}
