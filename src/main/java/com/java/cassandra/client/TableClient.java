package com.java.cassandra.client;

import com.datastax.driver.core.Session;
import com.java.cassandra.api.KeySpace;
import com.java.cassandra.api.Table;
import com.java.cassandra.connector.CassandraConnector;

import java.util.List;

public class TableClient {

    public static void main(String[] args){
        CassandraConnector connector = new CassandraConnector();
        connector.connect("127.0.0.1", null);

        Session session = connector.getSession();

        KeySpace keySpace = new KeySpace(session);
        keySpace
                .createKeySpace("cassandra_java", "SimpleStrategy", 1);
        keySpace.useKeySpace("cassandra_java");

        Table table = new Table(session);
        table.createUserByVideoTable();

        List<String> tables = table.listTables();
        System.out.println("Table Names: ");
        tables.forEach(tableName -> System.out.println(tableName));

        connector.close();
    }
}
