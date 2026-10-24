package com.example.jharkhandtourguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.PopupMenu;


public class MainActivity extends AppCompatActivity {
    private TextView tvWelcome;
    private Button btnExplore, btnSaved, btnMenu;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvWelcome = findViewById(R.id.tvWelcome);
        btnExplore = findViewById(R.id.btnExplore);
        btnSaved = findViewById(R.id.btnSaved);
        sp = getSharedPreferences("login_data", MODE_PRIVATE);
        editor = sp.edit();
        String username = sp.getString("Username", "");

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnMenu);

            popupMenu.getMenu().add("Logout");

            popupMenu.setOnMenuItemClickListener(item -> {

                if (item.getTitle().toString().equals("Logout")) {

                    editor.clear();
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                    return true;
                }

                return false;
            });

            popupMenu.show();
        });

        if (!username.isEmpty()){
            tvWelcome.setText("Welcome, " + username);
        }
        btnExplore.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, DestinationListActivity.class);
            startActivity(i);
        });
        btnSaved.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SavedPlacesActivity.class);
            startActivity(i);
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}