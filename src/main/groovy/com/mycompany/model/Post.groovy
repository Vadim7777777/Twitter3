package com.mycompany.model;

import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference

import java.time.Instant

@Document
class Post {

    @Id
    private String id;

    @Size(min = 10, max = 240)
    private String message;

    private Instant postDate = Instant.now();

    @DocumentReference
    private User author;

    @DocumentReference(lazy = true)
    private List<Like> likes;

    @DocumentReference(lazy = true)
    private List<Comment> comments;

    def getAuthor() {
        author
    }

    def setAuthor(User user) {
        this.author = user;
    }

    def getLikes() {
        likes
    }

    def List<Comment> getComments()
    {
        return comments;
    }

}
