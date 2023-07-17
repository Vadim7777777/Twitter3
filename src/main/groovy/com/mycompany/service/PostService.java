package com.mycompany.service;

import com.mycompany.model.Post;
import com.mycompany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    public void addPost(Post post)
    {
        postRepository.save(post);
    }

    public void removePost(Post post)
    {
        postRepository.delete(post);
    }
}
