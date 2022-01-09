package com.java.cassandra.api;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.List;
import java.util.stream.Collectors;

public class KeySpace {
    private Session session;

    public KeySpace(Session session){
        this.session = session;
    }

    public void createKeySpace(String name, String replicationStrategy, int replicationFactor){
        String query =
                new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                        .append(name).append(" WITH replication = {")
                        .append("'class':'").append(replicationStrategy)
                        .append("','replication_factor':").append(replicationFactor)
                        .append("};").toString();

        session.execute(query);
    }

    public void  useKeySpace(String name){
        session.execute("USE " + name);
    }

    public void deleteKepSpace(String name){
        String query = "DROP KEYSPACE "
                + name ;
        session.execute(query);
    }

    public List<String> listKeySpaces(){
        ResultSet result = session.execute("select * from system_schema.keyspaces;");
        List<String> keySpaces = result.all()
                .stream()
                .map(r -> r.getString(0))
                .collect(Collectors.toList());

        return keySpaces;
    }
}
