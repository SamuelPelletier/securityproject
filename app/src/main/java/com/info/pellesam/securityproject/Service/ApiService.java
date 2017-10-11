package com.info.pellesam.securityproject.Service;

import com.info.pellesam.securityproject.Entity.ListCategory;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService
{
    @GET("/securityprojectjsondata/data.json")
    Call<ListCategory> getMyJSON();
}
