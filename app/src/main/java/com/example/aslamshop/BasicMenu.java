package com.example.aslamshop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aslamshop.model.ShoppingItem;

import java.util.LinkedList;

public class BasicMenu extends AppCompatActivity {

    private static final String LOG_TAG = BasicMenu.class.getSimpleName();
    private final LinkedList<ShoppingItem> mItemList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private AdapterClass mAdapter;
    private int totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for (int i = 0; i < 10; i++){
            mItemList.add(new ShoppingItem(getResources().getString(R.string.spalding_basketball),
                    getResources().getString(R.string.carddescription), getResources().getString(R.string.cardprice),
                    getDrawable(R.drawable.spalding_ball) ,getResources().getInteger(R.integer.quantity)));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] options = {"Express ($50)", "regular ($10)", "no hurry (no cost)"};
        final AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Select delivery method");
        int select = 0;

        ad.setSingleChoiceItems(options, select, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Toast.makeText(BasicMenu.this, "$50 added for shipping", Toast.LENGTH_SHORT).show();
                        totalCost += 50;
                        break;
                    case 1:
                        Toast.makeText(BasicMenu.this, "$10 added for shipping", Toast.LENGTH_SHORT).show();
                        totalCost += 10;
                        break;
                    case 2:
                        Toast.makeText(BasicMenu.this, "No charge added", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog alert = ad.create();
                alert.show();
            }
        });

        mRecyclerView = findViewById(R.id.recycleView);
        mAdapter = new AdapterClass(this, mItemList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchCheckout(View view) {
        Log.d(LOG_TAG, "checkout activity opened");
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("total", totalCost);
        startActivity(intent);

    }
}
