package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailActivity extends AppCompatActivity {

    private String[][] order_details = {};
    ArrayList<HashMap<String, String>> list; // Change to ArrayList of HashMap
    SimpleAdapter sa;
    ListView lst;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        // Initialize UI elements
        btnBack = findViewById(R.id.OrderBack);
        lst = findViewById(R.id.listViewOrderCart);

        // Set a click listener for the back button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderDetailActivity.this, HomeActivity.class));
            }
        });

        // Retrieve the username from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Fetch order data from the database
        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        ArrayList<String> dbData = db.getOrderData(username);

        // Process and populate the order details
        order_details = new String[dbData.size()][5];

        for (int i = 0; i < order_details.length; i++) {
            String arrData = dbData.get(i);
            String[] strData = arrData.split("\\$");
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if ("medicine".equals(strData[7])) {
                order_details[i][3] = "Del: " + strData[4];
            } else {
                order_details[i][3] = "Del: " + strData[4] + " " + strData[5];
            }
            order_details[i][2] = "Rs." + strData[6];
            order_details[i][4] = strData[7];
        }

        list = new ArrayList<>();
        for (int i = 0; i < order_details.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }

        // Create a SimpleAdapter to display the order details
        sa = new SimpleAdapter(this, list,
                R.layout.multiple_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);
    }
}