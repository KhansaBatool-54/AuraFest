package com.example.aurafest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class VendorSignupActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button signupButton;
    TextView goToLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_signup);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signupButton = findViewById(R.id.signupButton);
        goToLogin = findViewById(R.id.goToLogin);

        mAuth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        Toast.makeText(this, "Vendor Signup Successful", Toast.LENGTH_SHORT).show();
                        // Navigate to vendor dashboard or login
                        startActivity(new Intent(this, VendorLoginActivity.class));
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Signup Failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    });
        });

        goToLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, VendorLoginActivity.class));
            finish();
        });
    }
}