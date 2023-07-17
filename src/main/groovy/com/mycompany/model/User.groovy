package com.mycompany.model

import lombok.Getter
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
@Getter
@Setter
class User {
    @Id
    private String id;

    private String firstName, lastName;
    private String email;

    @DocumentReference(lazy = true)
    private List<Post> posts = new ArrayList<Post>();

    @DocumentReference(lazy = true)
    private List<Like> likes = new ArrayList<Like>();

    @DocumentReference(lazy = true)
    private List<User> subscriptions = new ArrayList<Subscription>();

    def subscribeTo(User user) {
        subscriptions.add(user);
    }

    def unsubscribe(User user) {
        subscriptions.remove(user);
    }

    def isSubscribedTo(User target) {
        return subscriptions.contains(target);
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

    def addPost(Post post) {
        this.posts.add(post);
    }

    def getPosts() {
        return this.posts;
    }

    def getSubscriptions() {
        return this.subscriptions;
    }

}
