package com.example.utsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    TextView price, bal;
    Button pa;
    Button ba;
    private int userBalance = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        price = (TextView) findViewById(R.id.txtPrice);
        bal = (TextView) findViewById(R.id.txtBal);
        pa = (Button) findViewById(R.id.btnPay);
        ba = (Button) findViewById(R.id.btnBack);

        if(getIntent().hasExtra("OLD_BALANCE")){
            userBalance = getIntent().getIntExtra("OLD_BALANCE", 0);
        }

        final ArrayList<Item> shoppingCart = (ArrayList<Item>) getIntent().getSerializableExtra("SHOPCART");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,shoppingCart);
        int totalPrice = 0;
        for (Item i: shoppingCart
        ) {
            totalPrice += i.getPrice();
        }

        price.setText(String.valueOf(totalPrice));
        bal.setText(String.valueOf(userBalance));
        final int finalTotalPrice = totalPrice;
        pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //int num = Integer.parseInt(txtBa.getText().toString());
                userBalance -= finalTotalPrice;
                bal.setText(String.valueOf(userBalance));

                Intent intent = new Intent();
                intent.putExtra("NEW_BALANCE", userBalance);
                setResult(6, intent);
                finish();
            }
        });

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBalance -=0;
                bal.setText(String.valueOf(userBalance));

                Intent intent = new Intent();
                intent.putExtra("NEW_BALANCE", userBalance);
                setResult(2, intent);
                finish();
            }
        });
    }
}