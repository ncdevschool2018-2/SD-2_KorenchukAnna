package com.netcracker.backend.repository;

import com.netcracker.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UsersEntity, Long> {


}
