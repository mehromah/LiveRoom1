package com.example.liveroomforshoppingapp1.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.liveroomforshoppingapp1.model.api.JsonResponse;

import java.util.List;

@Dao
public abstract class LocalDataSource  {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void saveJsonResponseList(List<JsonResponse> jsonResponseList);

    @Update
    public abstract void update(List<JsonResponse> jsonResponses);

    @Query("SELECT * FROM tbl_PRSMBL003,tbl_PRSMBL004,tbl_PRSMBL005")
    LiveData<List<JsonResponse>> getJsonResponse(){
        return null;
    }

//    @Query("DELETE FROM tbl_prsmbl003,tbl_PRSMBL004,tbl_PRSMBL005")
//    public abstract void removeAllRows();


}
