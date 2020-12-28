package com.example.utsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Foods extends AppCompatActivity {

    Button btnOrd;
    Button fish,chicken,beef,lamb;
    Button btnOrd2;
    Button bac;
    TextView jFish, jChicken, jBeef, jLamb;
    int nFish = 0, nChicken = 0, nBeef = 0, nLamb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        btnOrd = (Button) findViewById(R.id.btnOrder);
        fish = (Button) findViewById(R.id.btnFish);
        btnOrd2 = (Button) findViewById(R.id.btnOrder2);
        chicken = (Button) findViewById(R.id.btnChicken);
        beef = (Button) findViewById(R.id.btnBeef);
        lamb = (Button) findViewById(R.id.btnLamb);
        jFish = (TextView) findViewById(R.id.cFish);
        jChicken = (TextView) findViewById(R.id.cChicken);
        jBeef = (TextView) findViewById(R.id.cBeef);
        jLamb = (TextView) findViewById(R.id.cLamb);
        bac = (Button) findViewById(R.id.btnBack);

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nFish, nChicken, nBeef, nLamb};
                nItem = new int[]{0, 0, 0, 0};
                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(4, intent);
                finish();
            }
        });
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nFish++;
                jFish.setText(String.valueOf(nFish));
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nChicken++;
                jChicken.setText(String.valueOf(nChicken));
            }
        });
        beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nBeef++;
                jBeef.setText(String.valueOf(nBeef));
            }
        });
        lamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nLamb++;
                jLamb.setText(String.valueOf(nLamb));
            }
        });
        btnOrd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nFish, nChicken, nBeef, nLamb};

                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(5, intent);
                finish();
            }
        });
    }


}