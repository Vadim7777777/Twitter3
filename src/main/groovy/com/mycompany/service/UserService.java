package com.mycompany.service;

import com.mycompany.model.User;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public void addUser(User user)
    {
        userRepository.save(user);
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

}
