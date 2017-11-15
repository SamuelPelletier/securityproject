package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.info.pellesam.securityproject.Custom.CustomViewAdapterCategories;
import com.info.pellesam.securityproject.DAO.CategoryDataSource;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.Item;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        TextView textView1 = (TextView) findViewById(R.id.title_category);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pistilli-Roman.otf");
        textView1.setTypeface(typeface);

        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://samuelpelletier.github.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService api = retrofit.create(ApiService.class);

            final Call<ListCategory> call = api.getMyJSON();
            call.enqueue(new Callback<ListCategory>() {
                @Override
                public void onResponse(Call<ListCategory> call, Response<ListCategory> response) {
                    if (response.isSuccessful()) {
                        categories = response.body().getCategories();
                        CategoryDataSource categoryDataSource = new CategoryDataSource(getApplicationContext());
                        categoryDataSource.open();
                        categoryDataSource.deleteAll();
                        for (int i =0; i < categories.size(); i++) {
                            for (int j = 0; j < categories.get(i).getItems().size(); j++) {
                                categoryDataSource.createCategory(categories.get(i).getTitle(), categories.get(i).getItems().get(j).getTitle(), categories.get(i).getItems().get(j).getUrlLogo(), categories.get(i).getItems().get(j).getUrlImage(), categories.get(i).getItems().get(j).getRegle(), categories.get(i).getItems().get(j).getDescription());
                            }
                        }
                        categoryDataSource.close();
                    }
                }

                @Override
                public void onFailure(Call<ListCategory> call, Throwable t) {
                }
            });
        }
        CategoryDataSource categoryDataSource = new CategoryDataSource(getApplicationContext());
        categoryDataSource.open();
        ArrayList<Category> categories = categoryDataSource.getAllCategories();
        categoryDataSource.close();
        listCategory = (ListView) findViewById(R.id.list_cat);
        listCategory.setAdapter((ListAdapter) new CustomViewAdapterCategories(getApplicationContext(), categories));

    }
}
