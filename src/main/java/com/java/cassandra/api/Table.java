package com.java.cassandra.api;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private Session session;
    private String VIDEO_BY_USER = "video_by_user";

    public Table(Session session){
        this.session = session;
    }

    public void createUserByVideoTable(){
        String query = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(VIDEO_BY_USER)
                .append("(video_id  uuid, ")
                .append("title text, ")
                .append("description text, ")
                .append("user_id uuid, ")
                .append("PRIMARY KEY(user_id));")
                .toString();

        session.execute(query);
    }

    public List<String> listTables(){
        ResultSet result = session
                .execute("select * from system_schema.tables where keyspace_name = 'cassandra_java';");

        List<String> tables = result.all()
                .stream()
                .map(r -> r.getString(1))
                .collect(Collectors.toList());

        return tables;
    }
}
