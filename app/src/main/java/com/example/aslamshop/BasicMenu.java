package com.example.aslamshop;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.aslamshop.model.ShoppingItem;

import java.util.LinkedList;

public class BasicMenu extends AppCompatActivity {

    private final LinkedList<ShoppingItem> mItemList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private AdapterClass mAdapter;
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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = findViewById(R.id.recycleView);
        mAdapter = new AdapterClass(this, mItemList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
