package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.info.pellesam.securityproject.Custom.CustomViewAdapterCategories;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.R;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class MainActivity extends Activity {

    private ListView listCategory;
    private ArrayList<Category> categories = new ArrayList<Category>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        Category cat1 = new Category("Cat1");
        Category cat2 = new Category("Cat2");
        Category cat3 = new Category("Cat3");
        Category cat4 = new Category("Cat4");
        Category cat5 = new Category("Cat5");

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);

        listCategory = (ListView) findViewById(R.id.list_cat);

        listCategory.setAdapter((ListAdapter) new CustomViewAdapterCategories(getApplicationContext(),categories));
    }
}
