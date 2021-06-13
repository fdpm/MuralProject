package com.example.themural.data.model;

import android.media.Image;
import java.util.ArrayList;

public class Main {

    private ArrayList<User> users;
    private ArrayList<Item> posts;

    public Main() {
        users = new ArrayList<User>();
        posts = new ArrayList<Item>();
    }

    public void newUser(String name, String nickname,String password, String phone, Image picture){

        if(name!= null && password!= null && phone!=null && picture!=null) {
            User newUser = new User(name, nickname,password, phone, picture);
            users.add(newUser);
        }
    }

    public void newUser(User user){
        if(user != null){
            users.add(user);
        }
    }

    public void editUser(String id, String name, String password, String phone, Image picture){

        if(name!= null && password!= null && phone!=null && picture!=null) {
            User editedUser = findUser(id);
            editedUser.setName(name);
            editedUser.setPassword(password);
            editedUser.setPhone(phone);
            editedUser.setPicture(picture);
        }
    }

    public void deleteUser(String id){
        User deletedUser = findUser(id);
        users.remove(deletedUser);
    }

    public User findUser(String id) {
        for(User user : users) {
            if(user.getUserId().equals(id))
                return user;
        }
        return null;
    }

    public void newPost(String nameItem, String descriptionItem, String locationItem, String typeItem, double priceItem, String stateItem, Image imageItem,User user){

        if (nameItem!=null && descriptionItem!=null && locationItem!=null && typeItem!=null && stateItem!=null && imageItem!=null && user!=null) {
            Item newPost = new Item(nameItem, descriptionItem, locationItem, typeItem, priceItem, stateItem, imageItem, user);
            posts.add(newPost);
        }
    }

    public void editPost(String id, String nameItem, String descriptionItem, String locationItem, String typeItem, double priceItem, String stateItem, Image imageItem){

        if (nameItem!=null && descriptionItem!=null && locationItem!=null && typeItem!=null && stateItem!=null && imageItem!=null) {
            Item editedPost = findPost(id);
            editedPost.setNameItem(nameItem);
            editedPost.setDescriptionItem(descriptionItem);
            editedPost.setLocationItem(locationItem);
            editedPost.setTypeItem(typeItem);
            editedPost.setPriceItem(priceItem);
            editedPost.setStateItem(stateItem);
            editedPost.setImageItem(imageItem);
        }
    }

    public void deletePost(String id){
        Item deletedPost = findPost(id);
        posts.remove(deletedPost);
    }

    public Item findPost(String id) {
        for(Item post : posts) {
            if(post.getIdItem().equals(id))
            return post;
        }
        return null;
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Item> getPosts() {
        return posts;
    }
}
