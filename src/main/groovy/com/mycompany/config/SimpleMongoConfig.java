package com.mycompany.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@Configuration
//@EnableMongoRepositories(basePackages = "com.mycompany.repository")
public class SimpleMongoConfig {

//    @Bean
//    public MongoClient mongo() throws Exception {
//        final ConnectionString connectionString = new ConnectionString("mongodb://root:secret@localhost:27017/");
//        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), "test");
//    }

}
