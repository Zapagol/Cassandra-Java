package com.java.cassandra.client;

import com.datastax.driver.core.Session;
import com.java.cassandra.api.KeySpace;
import com.java.cassandra.connector.CassandraConnector;

public class KeySpaceClient {

    public static void main(String[] args){
        CassandraConnector connector = new CassandraConnector();
        connector.connect("127.0.0.1", null);

        Session session = connector.getSession();

        KeySpace keySpace = new KeySpace(session);
        keySpace.createKeySpace("java_cassandra","SimpleStrategy",1);

        keySpace
                .listKeySpaces()
                .forEach(keyspace -> System.out.println(keyspace));

//        java_cassandra
//        system_auth
//        system_schema
//        system_distributed
//        system
//        system_traces

        keySpace.deleteKepSpace("java_cassandra");
        keySpace
                .listKeySpaces()
                .forEach(keyspace -> System.out.println(keyspace));

//        system_auth
//        system_schema
//        system_distributed
//        system
//        system_traces
        connector.close();
    }
}

