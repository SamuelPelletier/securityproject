package com.info.pellesam.securityproject.Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class Category implements Serializable{

    private String id;
    private String title;
    private ArrayList<Item> items;

    public Category() {
    }

    public Category(String title) {
        this.title = title;
    }

    public Category(String title, ArrayList<Item> subCategories) {
        this.title = title;
        this.items = items;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<Item> getItems() { return this.items; }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
