package com.example.whx.viewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by whx on 2016/7/23.
 */
public class SimpleDemoActivity extends AppCompatActivity{

    private static final String TAG = "SimpleDemoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

    }
}
