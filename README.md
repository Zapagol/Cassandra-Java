# Cassandra With Java

This project is an guide to use Apache Cassandra using Java.

##Maven Dependencies

-  Core Layer
```
    <dependency>
        <groupId>com.datastax.cassandra</groupId>
        <artifactId>cassandra-driver-core</artifactId>
        <version>3.1.0</version>
    </dependency>
```
-  Object Mapper
```
    <dependency>
        <groupId>com.datastax.cassandra</groupId>
        <artifactId>cassandra-driver-mapping</artifactId>
        <version>3.1.0</version>
    </dependency>
```
-  Test the code with embedded database server using cassandra-unit
```
    <dependency>
        <groupId>org.cassandraunit</groupId>
        <artifactId>cassandra-unit</artifactId>
        <version>3.0.0.1</version>
    </dependency>
```

## What you can learn as part of this project?
-  How to connect to Cassandra.
-  How to create KeySpaces.
-  How to create Create tables.