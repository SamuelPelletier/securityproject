package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.info.pellesam.securityproject.Custom.CustomViewAdapterCategories;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.ListCategory;
import com.info.pellesam.securityproject.R;
import com.info.pellesam.securityproject.Service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity
{

    private ListView listCategory;
    private ArrayList<Category> categories = new ArrayList<Category>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        TextView textView1 = (TextView) findViewById(R.id.title_category);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pistilli-Roman.otf");
        textView1.setTypeface(typeface);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samuelpelletier.github.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);

        final Call<ListCategory> call = api.getMyJSON();
        call.enqueue(new Callback<ListCategory>()
        {
            @Override
            public void onResponse(Call<ListCategory> call, Response<ListCategory> response)
            {
                if(response.isSuccessful())
                {
                    categories = response.body().getCategories();
                    listCategory = (ListView) findViewById(R.id.list_cat);
                    listCategory.setAdapter((ListAdapter) new CustomViewAdapterCategories(getApplicationContext(),categories));
                }
            }

            @Override
            public void onFailure(Call<ListCategory> call, Throwable t)
            {}
        });
    }
}
