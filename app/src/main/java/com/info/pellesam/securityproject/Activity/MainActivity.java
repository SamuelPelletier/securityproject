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
    private ArrayList<Category> categories;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        listCategory = (ListView) findViewById(R.id.list_cat);

        listCategory.setAdapter((ListAdapter) new CustomViewAdapterCategories(getApplicationContext(),categories));
    }
}
