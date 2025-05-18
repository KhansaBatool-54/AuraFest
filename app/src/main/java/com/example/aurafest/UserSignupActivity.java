package com.example.aurafest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class UserSignupActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button signupButton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        emailInput = findViewById(R.id.et_email);
        passwordInput = findViewById(R.id.et_password);
        signupButton = findViewById(R.id.btn_signup);
        auth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        finish(); // Go back to login
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Signup Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });
    }
}
