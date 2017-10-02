package com.info.pellesam.securityproject.Entity;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class Item {

    private String id;
    private String urlLogo;
    private String title;
    private String urlImage;
    private String regle;
    private String description;

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
}
