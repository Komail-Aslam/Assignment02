package com.example.aslamshop.model;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;

public class ShoppingItem {

    private String title;
    private String description;
    private String price;
    private Drawable img;
    private String quantity;

    public ShoppingItem(String title, String description, String price, Drawable img, String quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
