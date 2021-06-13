package com.example.themural.data.model;

import java.util.ArrayList;

public class Chat {

    public final static String SELLER ="seller";
    public final static String PURCHASER ="purchaser";

    private ArrayList<Message> message;

    private String type;

    public Chat(String type) {
        this.type = type;
        message = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessage() {
        return message;
    }

    public void addMessage(Message m){
        message.add(m);
    }

    public void setMessage(ArrayList<Message> message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
