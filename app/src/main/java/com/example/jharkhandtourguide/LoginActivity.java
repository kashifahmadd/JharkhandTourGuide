package com.example.jharkhandtourguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPass;
    private Button loginBtn;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        loginBtn = findViewById(R.id.loginBtn);

        sp = getSharedPreferences("login_data", MODE_PRIVATE);
        editor = sp.edit();
        if (sp.getBoolean("isLoggedIn", false)){
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            return;
        }

        loginBtn.setOnClickListener(v -> {
            String username = etName.getText().toString().trim();
            String password = etPass.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()){
                Snackbar.make(v,"Please Enter Username and Password", Snackbar.LENGTH_LONG).show();
            }else {
                editor.putBoolean("isLoggedIn", true);
                editor.putString("Username", username);
                editor.commit();
                Snackbar.make(v,"Login Successfull", Snackbar.LENGTH_LONG).show();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}