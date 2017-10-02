package com.info.pellesam.securityproject.Custom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.info.pellesam.securityproject.Activity.DisplayItemActivity;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.Item;
import com.info.pellesam.securityproject.R;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class CustomViewAdapterItems extends ArrayAdapter<Item> implements View.OnClickListener{

    private final Context context;
    private final ArrayList<Item> items;

    public CustomViewAdapterItems(Context context, ArrayList<Item> items){
        super(context, R.layout.list_category_view, items);
        this.context = context;
        this.items = items;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_view, parent, false);

        TextView itemTitle = (TextView) rowView.findViewById(R.id.item_title);

        itemTitle.setText(items.get(position).getTitle());

        itemTitle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(context, DisplayItemActivity.class);
                context.startActivity(myIntent);
            }
        });

        return rowView;
    }

    public void onClick(View v) {

    }
}
