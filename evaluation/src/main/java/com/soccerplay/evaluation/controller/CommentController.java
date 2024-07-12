package com.soccerplay.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccerplay.evaluation.entity.Comment;
import com.soccerplay.evaluation.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    
    final private CommentService commentService;
    
     @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

}
