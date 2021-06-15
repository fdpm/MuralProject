package com.example.themural.data.model;

import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.adapter.ItemView;

import java.util.ArrayList;
import java.util.Collections;

public class Main extends RecyclerView.Adapter<ItemView> {

    private ArrayList<User> users;
    private ArrayList<Item> posts;

    private ArrayList<Item> myPost;
    private String category;

    private OnItemListener onItemListener;


    public Main() {
        users = new ArrayList<User>();
        posts = new ArrayList<Item>();
        myPost = new ArrayList<Item>();
    }

    public void newUser(User user){
        if(user != null){
            users.add(user);
        }
    }

    public void newPost(Item post){
        if (post != null) {
            posts.add(post);
            this.notifyDataSetChanged();
        }
    }

    public void newMyPost(Item post){
        if(post!=null){
            myPost.add(post);
            this.notifyDataSetChanged();
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

    public void editPost(String id, String nameItem, String descriptionItem, String locationItem, String typeItem, double priceItem, int stateItem, Image imageItem){

        if (nameItem!=null && descriptionItem!=null && locationItem!=null && typeItem!=null  && imageItem!=null) {
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

    public void refreshPosts(){
        posts.clear();
    }

    public Item findPost(String id) {
        for(Item post : posts) {
            if(post.getIdItem().equals(id))
            return post;
        }
        return null;
    }

    public void filter(String category){
        ArrayList<Item> filteredPosts = new ArrayList<Item>();
        for (int i=0;i<posts.size();i++){
            if(posts.get(i).getTypeItem().equals(category)){
                    filteredPosts.add(posts.get(i));
            }
        }
        if (filteredPosts!=null) {
            posts = filteredPosts;
        }
    }

    public void reverse() {
        Collections.reverse(posts);
    }

    public Item searchPost(String name) {
        for(Item post : posts) {
            if(post.getIdItem().equals(name))
                return post;
        }
        return null;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Item> getPosts() {
        return posts;
    }

    public ArrayList<Item> getMyPost(){
        return myPost;
    }


    @NonNull
    @Override
    //Metodo que se ejecuta por cada item en el arreglo
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.itemrow,parent,false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ItemView itemView = new ItemView(rowroot, onItemListener);
        return itemView;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView holder, int position) {
        holder.getTitleItem().setText(posts.get(position).getNameItem());
        holder.getDescriptionItem().setText(posts.get(position).getDescriptionItem());
        holder.getLocationItem().setText(posts.get(position).getLocationItem());
        holder.getPriceItem().setText(""+posts.get(position).getPriceItem());
        holder.getTheItemType().setText(posts.get(position).getTypeItem());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }

}
