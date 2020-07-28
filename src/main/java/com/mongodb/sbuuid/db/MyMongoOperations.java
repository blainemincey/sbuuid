package com.mongodb.sbuuid.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

@Component("mongoOperations")
public class MyMongoOperations {

    @Autowired
    private MongoClientConfiguration mongoClientConfiguration;

    private MongoOperations mongoOps;

    /**
     *
     * @return
     */
    public MongoOperations getMongoOperations() {

        if (mongoOps == null) {
            mongoOps =
                    new MongoTemplate(new SimpleMongoClientDatabaseFactory(
                            mongoClientConfiguration.mongoClient(),
                            mongoClientConfiguration.getDatabaseName()));
        }
        return mongoOps;

    }
}
