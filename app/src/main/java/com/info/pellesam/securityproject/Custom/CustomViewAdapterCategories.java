package com.info.pellesam.securityproject.Custom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.info.pellesam.securityproject.Activity.DisplayItemsActivity;
import com.info.pellesam.securityproject.Activity.MainActivity;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.R;

import java.util.ArrayList;

/**
 * Created by pellesam on 02/10/2017.
 */

public class CustomViewAdapterCategories extends ArrayAdapter<Category> implements View.OnClickListener{

    private final Context context;
    private final ArrayList<Category> categories;

    public CustomViewAdapterCategories(Context context, ArrayList<Category> categories){
        super(context, R.layout.list_category_view, categories);
        this.context = context;
        this.categories = categories;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_category_view, parent, false);

        TextView categoryTitle = (TextView) rowView.findViewById(R.id.category_title);

        categoryTitle.setText(categories.get(position).getTitle());

        categoryTitle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Category category = categories.get(position);
                Intent myIntent = new Intent(context, DisplayItemsActivity.class);
                context.startActivity(myIntent);

            }
        });

        return rowView;
    }

    public void onClick(View v) {

    }
}
