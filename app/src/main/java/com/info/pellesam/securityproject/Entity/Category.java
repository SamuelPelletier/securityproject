package com.info.pellesam.securityproject.Entity;

/**
 * Created by pellesam on 02/10/2017.
 */

public class Category {

    private String id;
    private String title;

    public Category(String title) {
        this.title = title;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
}
