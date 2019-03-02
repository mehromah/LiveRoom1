package com.example.liveroomforshoppingapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract int getCoordinatorLayoutId();

    public void showSnackBarMessage(String message) {
        Snackbar.make(findViewById(getCoordinatorLayoutId()),
                message, Snackbar.LENGTH_SHORT).show();
    }


}
