package com.info.pellesam.securityproject.Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class Item implements Serializable{

    private String id;
    private String urlLogo;
    private String title;
    private String urlImage;
    private String regle;
    private String description;

    public Item(){};

    public Item(String urlLogo, String title, String urlImage, String regle, String description) {
        this.urlLogo = urlLogo;
        this.title = title;
        this.urlImage = urlImage;
        this.regle = regle;
        this.description = description;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getRegle() {
        return regle;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
