package com.example.aurafest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnUser, btnVendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure your layout file is named activity_main.xml

        // Find buttons by ID
        btnUser = findViewById(R.id.btn_user);
        btnVendor = findViewById(R.id.btn_vendor);

        // Go to UserLoginActivity
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent(MainActivity.this, UserLoginActivity.class);
                startActivity(userIntent);
            }
        });

        // Go to VendorLoginActivity
        btnVendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vendorIntent = new Intent(MainActivity.this, VendorLoginActivity.class);
                startActivity(vendorIntent);
            }
        });
    }
}
