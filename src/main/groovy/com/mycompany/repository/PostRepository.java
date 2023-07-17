package com.mycompany.repository;

import com.mycompany.model.Post;
import com.mycompany.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByAuthor(User author);

}
