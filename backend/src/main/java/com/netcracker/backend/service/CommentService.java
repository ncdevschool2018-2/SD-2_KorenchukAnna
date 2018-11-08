package com.netcracker.backend.service;

import com.netcracker.backend.entity.CommentsEntity;

public interface CommentService {
    CommentsEntity createComment(CommentsEntity user);
    Iterable<CommentsEntity> getAllCommentsByTaskId(long id);

    void deleteCoomentById(long id);

}