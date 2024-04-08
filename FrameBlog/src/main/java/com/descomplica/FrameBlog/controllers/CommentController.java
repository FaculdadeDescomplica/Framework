package com.descomplica.FrameBlog.controllers;

import com.descomplica.FrameBlog.models.Comment;
import com.descomplica.FrameBlog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(path = "/save")
    private @ResponseBody Comment save(@RequestBody Comment comment) {
        return commentService.send(comment);
    }

}