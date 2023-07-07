package com.mycompany.model


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document
class Like {

    @Id
    private LikeKey id;

    static class LikeKey {

        @DocumentReference
        private Post post;

        @DocumentReference
        private User likedBy;

        def setLikedBy(User user) {
            likedBy = user;
        }

        def setPost(Post post) {
            this.post = post;
        }
    }

    def getId() {id};

    def setLike(User user, Post post) {

        if (id == null)
            id = new LikeKey(post, user);

        id.setLikedBy(user);
        id.setPost(post);
    }
}
