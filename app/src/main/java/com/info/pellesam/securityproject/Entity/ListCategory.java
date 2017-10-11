package com.info.pellesam.securityproject.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ListCategory implements Serializable
{
    @SerializedName("Categories")
    @Expose
    private ArrayList<Category> categories = new ArrayList<Category>();

    public ArrayList<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories)
    {
        this.categories = categories;
    }
}
