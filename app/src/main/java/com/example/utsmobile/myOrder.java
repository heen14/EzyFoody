package com.example.utsmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class myOrder extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        listView = (ListView) findViewById(R.id.listview);

        final ArrayList<Item> shoppingCart = (ArrayList<Item>) getIntent().getSerializableExtra("SHOPCART");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,shoppingCart);
        listView.setAdapter(arrayAdapter);


        int totalPrice = 0;
        for (Item i: shoppingCart
             ) {
            totalPrice += i.getPrice();
        }
        System.out.println(totalPrice);

    }

}
//for (Item i: shoppingCart
//                 ) {
//                System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
//            }
