package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

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
    private ArrayList<Item> items;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_view);

        listItem = (ListView) findViewById(R.id.list_item);

        listItem.setAdapter((ListAdapter) new CustomViewAdapterItems(getApplicationContext(),items));
    }
}

