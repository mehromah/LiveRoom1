package com.example.liveroomforshoppingapp1.data;

import android.arch.lifecycle.LiveData;
import android.telecom.Call;

import com.example.liveroomforshoppingapp1.model.api.JsonResponse;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;


public interface ShoppingDataSource {
    LiveData<List<JsonResponse>> getJsonResponse();




}
