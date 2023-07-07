package com.mycompany.repository;


import com.mycompany.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, Subscription.SubscriptionKey> {


}
