package com.example.themural.data.model;

import android.media.Image;

public class User {

    public final static String SELLER ="seller";
    public final static String PURCHASER ="purchaser";

    private static Main main;
    private Chat chat;

    private String id;
    private String name;
    private String password;
    private String phone;
    private Image picture;
    private String type;

    public User(String id, String name, String password, String phone, Image picture, String type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.picture = picture;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
