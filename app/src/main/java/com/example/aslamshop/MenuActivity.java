package com.example.aslamshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.aslamshop.R.id.cardPrice;
import static com.example.aslamshop.R.id.cardQuantity;
import static com.example.aslamshop.R.id.cardTotal;

public class MenuActivity extends AppCompatActivity {

    private static final String LOG_TAG = MenuActivity.class.getSimpleName();
    private TextView quantityTextView; //view used to assign the quantity view from the layout to
    private int quantity; //the quantity of the item to be bought
    private double quantityTotal; //the total price of all the quantity of the layout
    private double price; //the price of the item in the layout
    public double overalltotal; //variable to keep track of the total of all the items in the menu
    public static final String intentkey = "com.example.android.aslamshop.extra.key"; //key for the intent to pass the overalltotal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        quantityTextView = findViewById(cardQuantity);
    }

    public void launchCheckoutActivity(View view) {
        Log.d(LOG_TAG, "checkout button clicked");
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra(intentkey, overalltotal);
        startActivity(intent);
    }

    //increase and decrease method for each layout(An increase and decrease unique to its layout
    public void increase(View view){
        quantityTextView = (TextView) findViewById(cardQuantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity++;
        quantityTextView.setText(Integer.toString(quantity));

        TextView priceOfItem = (TextView) findViewById(cardPrice);
        price = Double.parseDouble(priceOfItem.getText().toString());

        TextView quantityTotalView = (TextView) findViewById(cardTotal);
        quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
        quantityTotal += price;
        quantityTotalView.setText(String.format("%.2f",quantityTotal));

        overalltotal += price;
    }

    public void decrease(View view){
        TextView quantityTextView = (TextView) findViewById(cardQuantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        if (quantity > 0) {
            quantity--;
            quantityTextView.setText(Integer.toString(quantity));

            TextView priceOfItem = (TextView) findViewById(cardPrice);
            price = Double.parseDouble(priceOfItem.getText().toString());

            TextView quantityTotalView = (TextView) findViewById(cardTotal);
            quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
            quantityTotal -= price;
            quantityTotalView.setText(String.format("%.2f",quantityTotal));
            overalltotal -= price;
        }
    }
    public void increase2(View view){
        quantityTextView = (TextView) findViewById(R.id.card2quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity++;
        quantityTextView.setText(Integer.toString(quantity));

        TextView priceOfItem = (TextView) findViewById(R.id.card2price);
        price = Double.parseDouble(priceOfItem.getText().toString());

        TextView quantityTotalView = (TextView) findViewById(R.id.card2total);
        quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
        quantityTotal += price;
        quantityTotalView.setText(String.format("%.2f",quantityTotal));
        overalltotal += price;
    }

    public void decrease2(View view){
        TextView quantityTextView = (TextView) findViewById(R.id.card2quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        if (quantity > 0) {
            quantity--;
            quantityTextView.setText(Integer.toString(quantity));

            TextView priceOfItem = (TextView) findViewById(R.id.card2price);
            price = Double.parseDouble(priceOfItem.getText().toString());

            TextView quantityTotalView = (TextView) findViewById(R.id.card2total);
            quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
            quantityTotal -= price;
            quantityTotalView.setText(String.format("%.2f",quantityTotal));
            overalltotal -= price;
        }
    }
    public void increase3(View view){
        quantityTextView = (TextView) findViewById(R.id.card3quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity++;
        quantityTextView.setText(Integer.toString(quantity));

        TextView priceOfItem = (TextView) findViewById(R.id.card3price);
        price = Double.parseDouble(priceOfItem.getText().toString());

        TextView quantityTotalView = (TextView) findViewById(R.id.card3total);
        quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
        quantityTotal += price;
        quantityTotalView.setText(String.format("%.2f",quantityTotal));
        overalltotal += price;
    }

    public void decrease3(View view){
        TextView quantityTextView = (TextView) findViewById(R.id.card3quantity);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        if (quantity > 0) {
            quantity--;
            quantityTextView.setText(Integer.toString(quantity));

            TextView priceOfItem = (TextView) findViewById(R.id.card3price);
            price = Double.parseDouble(priceOfItem.getText().toString());

            TextView quantityTotalView = (TextView) findViewById(R.id.card3total);
            quantityTotal = Double.parseDouble(quantityTotalView.getText().toString());
            quantityTotal -= price;
            quantityTotalView.setText(String.format("%.2f",quantityTotal));
            overalltotal -= price;
        }
    }
}
