package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HealthIssuesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_issues);

        //card events

        CardView exit = findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HealthIssuesActivity.this, HomeActivity.class));
            }
        });

        CardView diabetes = findViewById(R.id.cardDiabetes);
        diabetes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(HealthIssuesActivity.this, DiabetesActivity.class);
                it.putExtra("title", "Diabetes");
                startActivity(it);
            }
        });

        CardView cardio = findViewById(R.id.cardCardiology);
        cardio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(HealthIssuesActivity.this, CardioActivity.class);
                it.putExtra("title", "CVD");
                startActivity(it);
            }
        });

        CardView physician = findViewById(R.id.cardPhysician);
        physician.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(HealthIssuesActivity.this, PhysicianActivity.class);
                it.putExtra("title", "Physician");
                startActivity(it);
            }
        });

    }
}