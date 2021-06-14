package com.example.themural.data.model;

import java.util.Date;
import java.util.UUID;

public class Message {

    private String id;
    private String content;
    private long date;

    public Message(String content){
        this.content=content;
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
}
