package com.netcracker.backend.repository;

import com.netcracker.backend.entity.AccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<AccountsEntity, Long> {

    Optional<AccountsEntity> findAccountByLogin(String login);

}
