package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PortalActivity extends AppCompatActivity {

    Button Pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        Pay = (Button)findViewById(R.id.pay);
        Pay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Payment was Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PortalActivity.this, HomeActivity.class));
            }
        });
    }
}