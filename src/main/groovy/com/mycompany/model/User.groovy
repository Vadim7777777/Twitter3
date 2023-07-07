package com.mycompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
class User {
    @Id
    private String id;

    private String firstName, lastName;
    private String email;

    @DocumentReference(lazy = true)
    private List<Post> posts;

    @DocumentReference(lazy = true)
    private List<Like> likes;

    @DocumentReference(lazy = true)
    private List<Subscription> subscriptions;

    def subscribeTo(User user) {
        subscriptions.add(new Subscription(this, user));
    }

    def unsubscribe(User user) {
        subscriptions.remove(new Subscription(this, user));
    }

    def likePost(Post post) {
        Like like = new Like();

        like.setLike(this, post);

        likes.add(like);
    }

    def unlikePost(Post post) {
        Like like = new Like();

        like.getId().setPost(post);
        like.getId().setLikedBy(this);

        likes.remove(like);
    }

    def commentPost(Post post, String message) {
        Comment comment = new Comment();

        post.getComments().add(comment);
    }

}
