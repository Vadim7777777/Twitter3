package com.mycompany.repository;

import com.mycompany.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, Like.LikeKey> {

}
