package com.mycompany.service;

import com.mycompany.model.Comment;
import com.mycompany.model.Post;
import com.mycompany.repository.CommentRepository;
import com.mycompany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    public PostRepository postRepository;

    public void addComment(Post post, Comment comment)
    {
        post.getComments().add(comment);

        postRepository.save(post);
        commentRepository.save(comment);
    }

    public void removeComment(Post post, Comment comment)
    {
        post.getComments().remove(comment);
        postRepository.save(post);

        commentRepository.delete(comment);
    }
}
