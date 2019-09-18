package com.example.aslamshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMenuActivity(View view) {
        Log.d(LOG_TAG, "menu activity opened");
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}
