package com.example.utsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Snacks extends AppCompatActivity {

    Button btnOrd;
    Button chitato,oreo,pringles,lays;
    Button btnOrd2;
    Button bac;
    TextView jChitato, jOreo, jPringles, jLays;
    int nChitato = 0, nOreo = 0, nPringles = 0, nLays = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        btnOrd = (Button) findViewById(R.id.btnOrder);
        chitato = (Button) findViewById(R.id.btnChitato);
        btnOrd2 = (Button) findViewById(R.id.btnOrder2);
        oreo = (Button) findViewById(R.id.btnOreo);
        pringles = (Button) findViewById(R.id.btnPringles);
        lays = (Button) findViewById(R.id.btnLays);
        jChitato = (TextView) findViewById(R.id.cChitato);
        jOreo = (TextView) findViewById(R.id.cOreo);
        jPringles = (TextView) findViewById(R.id.cPringles);
        jLays = (TextView) findViewById(R.id.cLays);
        bac = (Button) findViewById(R.id.btnBack);

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nChitato, nLays, nOreo, nPringles};
                nItem = new int[]{0, 0, 0, 0};
                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(5, intent);
                finish();
            }
        });
        chitato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nChitato++;
                jChitato.setText(String.valueOf(nChitato));
            }
        });
        oreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nOreo++;
                jOreo.setText(String.valueOf(nOreo));
            }
        });
        pringles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPringles++;
                jPringles.setText(String.valueOf(nPringles));
            }
        });
        lays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nLays++;
                jLays.setText(String.valueOf(nLays));
            }
        });
        btnOrd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nItem = {nChitato, nOreo, nPringles, nLays};

                Intent intent = new Intent();
                intent.putExtra("NEW_ITEMS", nItem);
                setResult(4, intent);
                finish();
            }
        });
    }


}