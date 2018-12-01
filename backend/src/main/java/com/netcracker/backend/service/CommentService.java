package com.netcracker.backend.service;

import com.netcracker.backend.entity.CommentsEntity;

public interface CommentService {

    CommentsEntity createComment(CommentsEntity comment);
    Iterable<CommentsEntity> getAllCommentsByTaskCode(String taskCode);
    void deleteCommentById(long id);

}