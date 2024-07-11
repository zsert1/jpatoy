package com.soccerplay.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerplay.evaluation.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}