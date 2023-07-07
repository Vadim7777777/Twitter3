package com.mycompany.repository;

import com.mycompany.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
