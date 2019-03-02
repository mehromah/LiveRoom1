package com.example.liveroomforshoppingapp1.model.api;

import com.example.liveroomforshoppingapp1.data.ShoppingDataSource;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitSingleton implements ShoppingDataSource {
    protected Retrofit retrofit;

    public RetrofitSingleton() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://37.191.82.13:6139/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
    }


}
