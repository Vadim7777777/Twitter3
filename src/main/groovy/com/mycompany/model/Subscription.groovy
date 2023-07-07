package com.mycompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document
class Subscription {

    @Id
    private SubscriptionKey subscription;

    Subscription(User subscribee, User subscribedTo) {
        subscription = new SubscriptionKey(subscribee, subscribedTo);
    }

    static class SubscriptionKey implements Serializable {

        @DocumentReference
        private User subscribee;

        @DocumentReference
        private User subscribedTo;
    }

}
