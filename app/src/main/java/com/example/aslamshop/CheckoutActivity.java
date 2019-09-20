package com.example.aslamshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheckoutActivity extends AppCompatActivity {

    private double sumbeforetax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intentnew = getIntent();
        sumbeforetax = (intentnew.getDoubleExtra(MenuActivity.intentkey, 0));

        TextView view = findViewById(R.id.totalBeforeNum);
        view.setText(String.format("$%.2f", sumbeforetax));

        view = findViewById(R.id.tpsNum);
        double tpsamount = (sumbeforetax * 0.05);
        view.setText(String.format("$%.2f", tpsamount));

        view = findViewById(R.id.tvqNum);
        double tvqamount = (sumbeforetax * 0.09975);
        view.setText(String.format("$%.2f", tvqamount));

        view = findViewById(R.id.totalAfterNum);
        double totalaftertax = sumbeforetax + tpsamount + tvqamount;
        view.setText(String.format("$%.2f", totalaftertax));
    }


}
