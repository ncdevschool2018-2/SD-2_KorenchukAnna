package com.netcracker.backend.repository;

import com.netcracker.backend.entity.CommentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentsEntity, Long> {


}

