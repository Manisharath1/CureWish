package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private Button cash;
    private Button credit;
    private Button debit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cash =(Button) findViewById(R.id.Cash);
        credit = (Button) findViewById(R.id.Credit);
        debit = (Button) findViewById(R.id.Debit);

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Booking Confirmed !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentActivity.this, HomeActivity.class));
            }
        });

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

        debit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });
    }
    public void nextPage(){
        Intent intent = new Intent(this,PortalActivity.class);
        startActivity(intent);
    }
}
