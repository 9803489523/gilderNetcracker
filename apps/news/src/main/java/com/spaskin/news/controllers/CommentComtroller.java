package com.spaskin.news.controllers;

import com.spaskin.news.entity.Comment;
import com.spaskin.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@RestController
public class CommentComtroller {

    private final CommentService commentService;

    @Autowired
    public CommentComtroller(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping(value = "/comment")
    public ResponseEntity<?> create(@RequestBody Comment comment){
        commentService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/comment")
    public ResponseEntity<List<Comment>> read(){
        final  List<Comment> commentList = commentService.readAll();

        return commentList != null && !commentList.isEmpty()
                ? new ResponseEntity<>(commentList, HttpStatus.OK)
                : new ResponseEntity<>(commentList, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comment/{id}")
    public  ResponseEntity<Comment> read(@PathVariable(name = "id") int id){
        final Comment comment = commentService.read(id);

        return comment != null
                ? new ResponseEntity<>(comment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/comment/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Comment comment){
        final boolean update = commentService.update(comment, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = commentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
