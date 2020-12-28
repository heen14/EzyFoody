package com.example.utsmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public Button btnOrd, btnPa, btnDrin, btnTop, btnSnac, btnFoo;
    public int userBalance;

    ArrayList<Item> shoppingCart = new ArrayList<>();

    TextView balDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOrd = (Button) findViewById(R.id.btnOrder);
        btnPa = (Button) findViewById(R.id.btnPay);
        btnDrin = (Button) findViewById(R.id.btnDrink);
        btnSnac = (Button) findViewById(R.id.btnSnack);
        btnFoo = (Button) findViewById(R.id.btnFood);

        btnTop = (Button) findViewById(R.id.btnTopup);
        balDisplay = (TextView) findViewById(R.id.balDisplay);
        balDisplay.setText(String.valueOf(userBalance));


        btnOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, myOrder.class);
                intent.putExtra("SHOPCART", (Serializable) shoppingCart);
                startActivity(intent);

            }
        });
        btnPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Payment.class);
                intent.putExtra("SHOPCART", (Serializable) shoppingCart);
                intent.putExtra("OLD_BALANCE", userBalance);
                startActivityForResult(intent, 6);

            }
        });
        btnDrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Drinks.class);
                startActivityForResult(intent2, 3);
            }
        });
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Balance.class);

                intent3.putExtra("OLD_BALANCE", userBalance);
                startActivityForResult(intent3, 2);
            }
        });
        btnSnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, Snacks.class);
                startActivityForResult(intent4, 4);
            }
        });
        btnFoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent (MainActivity.this, Foods.class);
                startActivityForResult(intent5, 5);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            int tempBalance = data.getIntExtra("NEW_BALANCE", userBalance);
            userBalance = tempBalance;
            balDisplay.setText(String.valueOf(userBalance));
        }
        if (requestCode == 6) {
            int tempBalance = data.getIntExtra("NEW_BALANCE", userBalance);
            if(userBalance>tempBalance){
                userBalance = tempBalance;
                shoppingCart.clear();
                balDisplay.setText(String.valueOf(userBalance));
            }

        }

        if (requestCode == 3) {
            int[] tempCount = data.getIntArrayExtra("NEW_ITEMS");

            if (tempCount[0] > 0)
                shoppingCart.add(new Item("Juice", 10000 * tempCount[0], tempCount[0]));
            if (tempCount[1] > 0)
                shoppingCart.add(new Item("Sprite", 8000 * tempCount[1], tempCount[1]));
            if (tempCount[2] > 0)
                shoppingCart.add(new Item("Beer", 20000 * tempCount[2], tempCount[2]));
            if (tempCount[3] > 0)
                shoppingCart.add(new Item("Coca cola", 9000 * tempCount[3], tempCount[3]));

//            for (Item i: shoppingCart
//                 ) {
//                System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
//            }

        }
        if (requestCode == 4) {
            int[] tempCount = data.getIntArrayExtra("NEW_ITEMS");

            if (tempCount[0] > 0)
                shoppingCart.add(new Item("Chitato", 12000 * tempCount[0], tempCount[0]));
            if (tempCount[1] > 0)
                shoppingCart.add(new Item("Oreo", 6000 * tempCount[1], tempCount[1]));
            if (tempCount[2] > 0)
                shoppingCart.add(new Item("Pringles", 18000 * tempCount[2], tempCount[2]));
            if (tempCount[3] > 0)
                shoppingCart.add(new Item("Lays", 9000 * tempCount[3], tempCount[3]));

        }
        if (requestCode == 5) {
            int[] tempCount = data.getIntArrayExtra("NEW_ITEMS");

            if (tempCount[0] > 0)
                shoppingCart.add(new Item("Fish", 17000 * tempCount[0], tempCount[0]));
            if (tempCount[1] > 0)
                shoppingCart.add(new Item("Chicken", 20000 * tempCount[1], tempCount[1]));
            if (tempCount[2] > 0)
                shoppingCart.add(new Item("Beef", 40000 * tempCount[2], tempCount[2]));
            if (tempCount[3] > 0)
                shoppingCart.add(new Item("Lamb", 35000 * tempCount[3], tempCount[3]));

        }
    }
}

