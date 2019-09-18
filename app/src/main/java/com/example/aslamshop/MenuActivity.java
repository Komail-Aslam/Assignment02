package com.example.aslamshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.aslamshop.R.id.card1price;
import static com.example.aslamshop.R.id.card1quantity;
import static com.example.aslamshop.R.id.card1total;

public class MenuActivity extends AppCompatActivity {

    private static final String LOG_TAG = MenuActivity.class.getSimpleName();
    private TextView quantityTextView;
    private int quantity;
    private int quantityTotal;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        quantityTextView = findViewById(card1quantity);
    }

    public void launchCheckoutActivity(View view) {
        Log.d(LOG_TAG, "checkout button clicked");
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }

    public void increase(View view){
        TextView quantityTextView = (TextView) findViewById(card1quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity++;
        quantityTextView.setText(Integer.toString(quantity));
        TextView priceOfItem = (TextView) findViewById(card1price);
        price = Integer.parseInt(quantityTextView.getText().toString());
        TextView quantityTotalView = (TextView) findViewById(card1total);
        quantityTotal = Integer.parseInt(quantityTotalView.getText().toString());
        quantityTotal += price;
    }

    public void decrease(View view){
        TextView quantityTextView = (TextView) findViewById(card1quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        if (quantity > 0)
            quantity--;
        quantityTextView.setText(Integer.toString(quantity));
    }
}
