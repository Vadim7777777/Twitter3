package com.mycompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
class Subscription {

    @Id
    private SubscriptionKey subscription;

    Subscription(User subscriber, User subscribedTo) {
        subscription = new SubscriptionKey(subscriber, subscribedTo);
    }

    User getSubscriber() {
        return subscription.getSubscriber();
    }

    User getSubscribedTo() {
        return subscription.getSubscribedTo();
    }

    static class SubscriptionKey implements Serializable {

        @DocumentReference
        private User subscriber;

        @DocumentReference
        private User subscribedTo;

        SubscriptionKey() {}

        SubscriptionKey(User subscriber, User subscribedTo) {
            this.subscriber = subscriber;
            this.subscribedTo = subscribedTo;
        }

        User getSubscriber() {
            return subscriber;
        }

        User getSubscribedTo() {
            return subscribedTo;
        }
    }

}
