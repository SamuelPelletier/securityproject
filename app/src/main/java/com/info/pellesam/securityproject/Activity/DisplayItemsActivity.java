package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.content.Intent;
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
        category_title.setText(category.getTitle());

        Item item1 = new Item("http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","item1","http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","regles","description");
        items.add(item1);
        Item item2 = new Item("http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","item2","http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","regles","description");
        items.add(item2);
        Item item3 = new Item("http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","item3","http://www.gifsanimes.fr/clipart/cartoons/bob-l-eponge/bob-l-eponge-gifs-animes-6121879.jpg","regles","description");
        items.add(item3);

        listItem = (ListView) findViewById(R.id.list_items);

        listItem.setAdapter((ListAdapter) new CustomViewAdapterItems(getApplicationContext(),items));
    }
}

