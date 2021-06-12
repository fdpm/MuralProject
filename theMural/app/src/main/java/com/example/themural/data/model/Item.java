package com.example.themural.data.model;

import android.media.Image;
import java.util.UUID;

public class Item {

    private User user;

    private String idItem;
    private String nameItem;
    private String descriptionItem;
    private String locationItem;
    private String typeItem;
    private double priceItem;
    private String stateItem;
    private Image imageItem;

    public Item(String nameItem, String descriptionItem, String locationItem, String typeItem, double priceItem, String stateItem, Image imageItem, User users) {
        this.nameItem = nameItem;
        this.descriptionItem = descriptionItem;
        this.locationItem = locationItem;
        this.typeItem = typeItem;
        this.priceItem = priceItem;
        this.stateItem = stateItem;
        this.imageItem = imageItem;
        this.user = user;
        idItem = UUID.randomUUID().toString();
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public String getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(String locationItem) {
        this.locationItem = locationItem;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }

    public double getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(double priceItem) {
        this.priceItem = priceItem;
    }

    public String isStateItem() {
        return stateItem;
    }

    public void setStateItem(String stateItem) {
        this.stateItem = stateItem;
    }

    public Image getImageItem() {
        return imageItem;
    }

    public void setImageItem(Image imageItem) {
        this.imageItem = imageItem;
    }

    public User getUser() {
        return user;
    }
}
