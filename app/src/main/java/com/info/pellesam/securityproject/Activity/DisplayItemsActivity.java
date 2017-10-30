package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.info.pellesam.securityproject.Custom.CustomViewAdapterCategories;
import com.info.pellesam.securityproject.Custom.CustomViewAdapterItems;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.Item;
import com.info.pellesam.securityproject.R;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class DisplayItemsActivity extends Activity{

    private ListView listItem;
    private ArrayList<Item> items = new ArrayList<Item>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_view);
        Intent intent = getIntent();
        Category category = (Category) intent.getExtras().getSerializable("category");

        TextView category_title = (TextView) findViewById(R.id.cat_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pistilli-Roman.otf");
        category_title.setTypeface(typeface);
        category_title.setText(category.getTitle());
        items = category.getItems();

        listItem = (ListView) findViewById(R.id.list_items);

        listItem.setAdapter((ListAdapter) new CustomViewAdapterItems(getApplicationContext(),items));
    }
}

