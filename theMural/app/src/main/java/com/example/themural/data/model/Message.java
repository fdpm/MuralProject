package com.example.themural.data.model;

import java.util.Date;
import java.util.UUID;

public class Message {

    private String id;
    private String from;
    private String content;
    private long date;

    public Message(String content, String from){
        this.content=content;
        this.from = from;
        this.date = new Date().getTime();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }
}
