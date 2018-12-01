package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.UsersEntity;
import com.netcracker.backend.repository.UserRepository;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<UsersEntity> getAllUsers() {
        Iterable<UsersEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<UsersEntity> getUserById(long id) {
        Optional<UsersEntity> user = userRepository.findById(id);
        return user;
    }

    @Override
    public Optional<UsersEntity> getUserByAccountId(long accountId) {
        Optional<UsersEntity> user = userRepository.getUsersEntitiesByAccountId(accountId);
        return user;
    }


    @Override
    public UsersEntity createUser(UsersEntity us) {
        UsersEntity user = userRepository.save(us);
        return user;
    }

    @Override
    public UsersEntity updateAccount(UsersEntity user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
