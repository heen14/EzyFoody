package com.example.utsmobile;

//import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Balance extends AppCompatActivity {
    TextView  txtBalDisplay;
    Button addBa;
    Button ba;
    EditText txtBa;

    private int userBalance = 0;

    public int Bal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        txtBa = (EditText) findViewById(R.id.txtBal);
        addBa = (Button) findViewById(R.id.btnAddBal);
        txtBalDisplay = (TextView) findViewById(R.id.balDisplay) ;
        ba = (Button) findViewById(R.id.btnBack);

        if(getIntent().hasExtra("OLD_BALANCE")){
            userBalance = getIntent().getIntExtra("OLD_BALANCE", 0);
        }
        txtBalDisplay.setText(String.valueOf(userBalance));

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 0;
                userBalance +=num;
                txtBalDisplay.setText(String.valueOf(userBalance));

                Intent intent = new Intent();
                intent.putExtra("NEW_BALANCE", userBalance);
                setResult(2, intent);
                finish();
            }
        });

        addBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(txtBa.getText().toString());
                userBalance +=num;
                txtBalDisplay.setText(String.valueOf(userBalance));
                Intent intent = new Intent();
                intent.putExtra("NEW_BALANCE", userBalance);
                setResult(2, intent);
            }
        });



    }

}
