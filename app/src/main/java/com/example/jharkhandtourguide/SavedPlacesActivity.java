package com.example.jharkhandtourguide;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;

public class SavedPlacesActivity extends AppCompatActivity {
    private ListView lvSavedPlaces;
    private Button btnClearAll;
    private SharedPreferences sp;

    private String[] destinations = {
            "Baba Baidyanath Temple",
            "Dassam Falls",
            "Jubilee Park",
            "Parasnath Hills",
            "Maithon Dam",
            "Patratu Valley",
            "Rock Garden",
            "Hundru Falls",
            "Jonha Falls",
            "Dimna Lake",
            "Jagannath Mandir",
            "Yogoda Satsanga Dhyana Mandir",
            "Trikuta Parvata",
            "Basukinath Temple",
            "Dalma Wildlife Sanctuary",
            "Bhatinda Fall",
            "Rajrappa Temple",
            "Netarhat",
            "Birsa Zoological Park",
            "JRD Tata Sports Complex",
            "Massanjore Dam",
            "Naulakha Mandir",
            "Tata Steel Zoological Park",
            "Usri Falls",
            "Hirni Water Falls",
            "Topchanchi Wildlife Sanctuary",
            "Betla National Park"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saved_places);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvSavedPlaces = findViewById(R.id.lvSavedPlaces);
        btnClearAll = findViewById(R.id.btnClearAll);

        sp = getSharedPreferences("saved_places", MODE_PRIVATE);

        java.util.ArrayList<String> savedPlaces = new java.util.ArrayList<>();

        for (String destination : destinations) {
            if (sp.getBoolean(destination, false)) {
                savedPlaces.add(destination);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                savedPlaces
        );

        lvSavedPlaces.setAdapter(adapter);
        lvSavedPlaces.setOnItemClickListener((parent, view, position, id) -> {

            String destination = savedPlaces.get(position);

            int originalPosition = 0;

            for (int i = 0; i < destinations.length; i++) {
                if (destinations[i].equals(destination)) {
                    originalPosition = i;
                    break;
                }
            }

            Intent i = new Intent(
                    SavedPlacesActivity.this,
                    DestinationActivity.class
            );

            i.putExtra("destination", destination);
            i.putExtra("position", originalPosition);

            startActivity(i);
        });

        btnClearAll.setOnClickListener(v -> {

            sp.edit().clear().commit();

            savedPlaces.clear();
            adapter.notifyDataSetChanged();
        });
    }
}