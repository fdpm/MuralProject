package com.example.themural.data.model;

import android.media.Image;
import java.util.UUID;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class User {

    public final static String SELLER ="seller";
    public final static String PURCHASER ="purchaser";

    private static Main main;
    private Chat chat;
    private String nickName;
    private String userId;
    private String displayName;
    private String name;
    private String password;
    private String phone;
    private Image picture;
    private String type;

    public User(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public User(String userId, String displayName,String password){
        this.userId = userId;

        this.displayName = displayName;
        this.password = password;
    }

    public User(String name, String nickName, String password, String phone, Image picture) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.picture = picture;
        type = PURCHASER;
        userId = UUID.randomUUID().toString();

    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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