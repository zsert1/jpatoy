package com.soccerplay.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soccerplay.evaluation.entity.Comment;
import com.soccerplay.evaluation.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
  
    private  final CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
