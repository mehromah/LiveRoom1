package com.example.liveroomforshoppingapp1.model;

import android.arch.lifecycle.LiveData;
import com.example.liveroomforshoppingapp1.model.api.ApiService;
import com.example.liveroomforshoppingapp1.model.api.JsonResponse;
import com.example.liveroomforshoppingapp1.model.api.RetrofitSingleton;
import java.util.List;


public class MainCloudDataSource extends RetrofitSingleton {
    private ApiService apiService;
    public MainCloudDataSource() {
        super();
        apiService = retrofit.create(ApiService.class);

    }

    @Override
    public LiveData<List<JsonResponse>> getJsonResponse() {
        return apiService.getJSON();
    }
}
