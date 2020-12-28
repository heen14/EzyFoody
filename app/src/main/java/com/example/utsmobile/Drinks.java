package com.example.utsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Drinks extends AppCompatActivity {

    Button btnOrd;
    Button coca,sprite,juice,beer;
    Button btnOrd2;
    Button bac;
    TextView jJuice, jBeer, jSprite, jCoca;
    int nJuice = 0, nCoca = 0, nSprite = 0, nBeer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        btnOrd = (Button) findViewById(R.id.btnOrder);
        coca = (Button) findViewById(R.id.btnCoca);
        btnOrd2 = (Button) findViewById(R.id.btnOrder2);
        sprite = (Button) findViewById(R.id.btnSprite);
        juice = (Button) findViewById(R.id.btnJuice);
        beer = (Button) findViewById(R.id.btnBeer);
        jJuice = (TextView) findViewById(R.id.cJuice);
        jBeer = (TextView) findViewById(R.id.cBeer);
        jSprite = (TextView) findViewById(R.id.cSprite);
        jCoca = (TextView) findViewById(R.id.cCoca);
        bac = (Button) findViewById(R.id.btnBack);
        btnOrd.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(Drinks.this, MainActivity.class);
                startActivity(intent);

            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nJuice, nSprite, nBeer, nCoca};
                nItem = new int[]{0, 0, 0, 0};
                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(3, intent);
                finish();
            }
        });
        coca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nCoca++;
                jCoca.setText(String.valueOf(nCoca));
            }
        });
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nJuice++;
                jJuice.setText(String.valueOf(nJuice));
            }
        });
        beer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nBeer++;
                jBeer.setText(String.valueOf(nBeer));
            }
        });
        sprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nSprite++;
                jSprite.setText(String.valueOf(nSprite));
            }
        });
        btnOrd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nJuice, nSprite, nBeer, nCoca};

                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(3, intent);
                finish();
            }
        });
    }


}
