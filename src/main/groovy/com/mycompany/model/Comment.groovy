package com.mycompany.model;

import jakarta.validation.constraints.Size
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference

import java.time.Instant;

@Document
class Comment {

    @Id
    private ObjectId id;

    @Size(min = 10, max = 100)
    private String message;

    private Instant postDate = Instant.now();

    @DocumentReference
    private User author;

    def setMessage(String message)
    {
        this.message = message;
    }

}
