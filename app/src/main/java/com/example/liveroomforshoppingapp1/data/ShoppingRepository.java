package com.example.liveroomforshoppingapp1.data;

import android.annotation.TargetApi;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Build;
import com.example.liveroomforshoppingapp1.model.MainCloudDataSource;
import com.example.liveroomforshoppingapp1.model.api.JsonResponse;
import com.example.liveroomforshoppingapp1.model.api.RetrofitSingleton;
import java.util.Collections;
import java.util.List;



public class ShoppingRepository implements ShoppingDataSource {
    private  RetrofitSingleton cloudDataSource;
    private  LocalDataSource localDataSource;
    private  LiveData<List<JsonResponse>> JsonResponse;


    public ShoppingRepository(Application application) {
        localDataSource = AppDatabase.getInstance(application).getLocalDataSource();
        cloudDataSource = new MainCloudDataSource();
        JsonResponse = localDataSource.getJsonResponse();

    }

    @Override
    public LiveData<List<JsonResponse>> getJsonResponse() {
        localDataSource.saveJsonResponseList(cloudDataSource.getJsonResponse().getValue());
        return localDataSource.getJsonResponse();
    }


    LiveData<List<JsonResponse>> getGetJsonResponse() {
        return JsonResponse;
    }



    public void insert(JsonResponse jsonResponse) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            new insertAsyncTask(localDataSource).execute(jsonResponse);
        }
    }


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    private static class insertAsyncTask extends AsyncTask<JsonResponse, Void, Void> {

        private LocalDataSource mAsyncTaskDao;

        insertAsyncTask(LocalDataSource dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final JsonResponse... params) {
            mAsyncTaskDao.saveJsonResponseList(Collections.singletonList(params[0]));
            return null;
        }
    }





}
