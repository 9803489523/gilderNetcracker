package com.spaskin.news.service;

import com.spaskin.news.entity.Comment;
import com.spaskin.news.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void create(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    public Comment read(int id) {
        return commentRepository.getOne(id);
    }

    public boolean update(Comment comment, int id) {
        if (commentRepository.existsById(id)){
            comment.setIdComment(id);
            commentRepository.save(comment);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (commentRepository.existsById(id)){
         commentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
