# sbuuid

The purpose of this application is to provide an example on generated a 
unique identifier for a document using Spring Boot.

## Requirements
* Java 11
* Spring Boot
* Maven
* MongoDB

## High-level Steps
1. Edit the ```src/main/java/resources/application.properties``` file.  Modify the
properties to the values that are appropriate for your environment.  In a nutshell, 
if you are running MongoDB somewhere other than locally you will need to modify
the connection string.  All other values can remain the same.

2. From the root project directory: ```mvn clean package```

3. Edit the ```runit.zsh ``` script to what is appropriate in your environment. 
As long as you set a unique node.id value, the sequence generator will provide
a unique value.

4. A unique index will need to be created on the collection in MongoDB to enforce
a unique value as well as force any exceptions in the event there is a duplicate
value.  This should not happen.

5. Run the ```runit.zsh``` script.
