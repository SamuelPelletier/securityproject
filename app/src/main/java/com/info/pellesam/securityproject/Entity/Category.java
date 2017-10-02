package com.info.pellesam.securityproject.Entity;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class Category {

    private String id;
    private String title;
    private ArrayList<Item> items;

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

    public ArrayList<Item> getSubCategories() { return this.items; }
}
