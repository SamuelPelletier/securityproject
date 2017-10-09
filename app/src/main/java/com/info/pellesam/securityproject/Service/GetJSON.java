package com.info.pellesam.securityproject.Service;

import android.util.Log;

import com.info.pellesam.securityproject.Entity.Category;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Kelly Narboux on 09/10/2017.
 */

public class GetJSON {
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        try {

            String myurl = "https://samuelpelletier.github.io/securityprojectjsondata/data.json";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);
//
//            // On récupère le JSON complet
//            JSONObject jsonObject = new JSONObject(result);
//            // On récupère le tableau d'objets qui nous concernent
//            JSONArray array = new JSONArray(jsonObject.getString("personnes"));
//            // Pour tous les objets on récupère les infos
//            for (int i = 0; i < array.length(); i++) {
//                // On récupère un objet JSON du tableau
//                JSONObject obj = new JSONObject(array.getString(i));
//                // On fait le lien Personne - Objet JSON
//                Category category = new Category();
//                category.setTitle(obj.getString("title"));
//                // On ajoute la personne à la liste
//                categories.add(category);

        //}

        Log.i("TAG",result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
        return null;
    }
}
