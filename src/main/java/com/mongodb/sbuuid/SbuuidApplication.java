package com.mongodb.sbuuid;

import com.mongodb.sbuuid.db.MyMongoOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbuuidApplication implements CommandLineRunner {

    @Value("${num.docs.to.generate}")
    public int numDocsToGenerate;

    @Value("${node.id}")
    public int nodeId;

    @Autowired
    public MyMongoOperations mongoOperations;

    public static void main(String[] args) {
        SpringApplication.run(SbuuidApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==== Starting Spring Boot in Command Line Mode ====");
        System.out.println("Num Docs to Generate: " + numDocsToGenerate);
        System.out.println("Node Id: " + nodeId);

        // Pass the Node Id to sequence generator
        SequenceGenerator sequenceGenerator = new SequenceGenerator(nodeId);

        // loop thru num of docs to create
        for(int indx = 0; indx < numDocsToGenerate; indx++) {
            MyModel myModel = new MyModel(sequenceGenerator.nextId());
            mongoOperations.getMongoOperations().insert(myModel);
        }

        System.out.println("==== Complete ====");
    }
}
