package com.example.themural.data.model;

import android.media.Image;

import java.util.ArrayList;

public class Main {

    private ArrayList<LoggedInUser> users;
    private ArrayList<Item> posts;

    public Main() {
        users = new ArrayList<LoggedInUser>();
        posts = new ArrayList<Item>();
    }

    public void newUser(String name, String password, String phone, Image picture){

        if(name!= null && password!= null && phone!=null && picture!=null) {
            LoggedInUser newUser = new LoggedInUser(name, password, phone, picture);
            users.add(newUser);
        }
    }

    public void newPost(String nameItem, String descriptionItem, String locationItem, String typeItem, double priceItem, String stateItem, Image imageItem){

        if (nameItem!=null && descriptionItem!=null && locationItem!=null && typeItem!=null && stateItem!=null && imageItem!=null) {
            Item newPost = new Item(nameItem, descriptionItem, locationItem, typeItem, priceItem, stateItem, imageItem);
            posts.add(newPost);
        }
    }

    public ArrayList<LoggedInUser> getUsers() {
        return users;
    }

    public ArrayList<Item> getPosts() {
        return posts;
    }
}
