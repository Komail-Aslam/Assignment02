package com.example.aslamshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheckoutActivity extends AppCompatActivity {

    //Gets the intent and sets the overall total that was passed to the variable sumbeforetax
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intentnew = getIntent();
        double sumbeforetax = (intentnew.getIntExtra("total", 0));

        //Sets the textview for the total before taxes to sumbeforetax variable
        TextView view = findViewById(R.id.totalBeforeNum);
        view.setText(String.format("$%.2f", sumbeforetax));

        //Calculates and sets the tpx to the text view
        view = findViewById(R.id.tpsNum);
        double tpsamount = (sumbeforetax * 0.05);
        view.setText(String.format("$%.2f", tpsamount));

        //Calculates and sets the tvq to the text view
        view = findViewById(R.id.tvqNum);
        double tvqamount = (sumbeforetax * 0.09975);
        view.setText(String.format("$%.2f", tvqamount));

        //Adds the taxes to the totalbefore tax amount and set it to the total after taxes view
        view = findViewById(R.id.totalAfterNum);
        double totalaftertax = sumbeforetax + tpsamount + tvqamount;
        view.setText(String.format("$%.2f", totalaftertax));
    }
}
