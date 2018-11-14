package com.netcracker.backend.repository;

import com.netcracker.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    Optional<UsersEntity> getUsersEntitiesByAccountId(long accountId);

}
