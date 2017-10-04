package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.Item;
import com.info.pellesam.securityproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pellesam on 02/10/2017.
 */

public class DisplayItemActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        Intent intent = getIntent();
        Item item = (Item) intent.getExtras().getSerializable("item");

        TextView title_item = (TextView) findViewById(R.id.title_item);
        title_item.setText(item.getTitle());

        TextView regles = (TextView) findViewById(R.id.regles);
        regles.setText(item.getRegle());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(item.getDescription());

        ImageView image_item = (ImageView) findViewById(R.id.image_item);
        Glide.with(this).load(item.getUrlImage()).crossFade().into(image_item);
    }
}
