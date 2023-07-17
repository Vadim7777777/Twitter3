package com.mycompany.service;

import com.mycompany.model.Post;
import com.mycompany.model.Subscription;
import com.mycompany.model.User;
import com.mycompany.model.Wall;
import com.mycompany.repository.PostRepository;
import com.mycompany.repository.UserRepository;
import com.nimbusds.oauth2.sdk.RequestObjectPOSTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PostRepository postRepository;

    public void addUser(User user)
    {
        userRepository.save(user);

        List<Post> post = postRepository.saveAll((List<Post>)user.getPosts());
    }
    public void removeUser(User user)
    {
        userRepository.delete(user);
    }

    public void subscribeTo(User subscriber, User target) {
        subscriber.subscribeTo(target);

        userRepository.save(subscriber);
    }

    public void unsubscribe(User unsubscriber, User target) {
        unsubscriber.unsubscribe(target);

        userRepository.save(unsubscriber);
    }

    public Integer userCount() {
        return Math.toIntExact(userRepository.count());
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public boolean isUserSubscribedTo(User user, User target) {
        return (boolean) user.isSubscribedTo(target);
    }

    public Wall getUserWall(User user) {
        List<Post> allPosts = new ArrayList<Post>();
        Wall wall = new Wall();

        allPosts.addAll((List<Post>)user.getPosts());

        List<User> subscriptions = (List<User>) user.getSubscriptions();

        for (User subscription : subscriptions) {
            List<Post> postsFromSubscription = postRepository.findByAuthor(subscription);
            allPosts.addAll(postsFromSubscription);
        }

        Collections.sort(allPosts, (x, y) -> ((Instant)y.getPostDate()).compareTo((Instant)x.getPostDate()));

        wall.setPosts(allPosts);

        //add all posts of all subscribers
        return wall;
    }
}
