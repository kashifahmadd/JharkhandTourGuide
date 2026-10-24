package com.example.jharkhandtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DestinationListActivity extends AppCompatActivity {
    private ListView lvDest;
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
        setContentView(R.layout.activity_destination_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvDest = findViewById(R.id.lvDest);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, destinations);
        lvDest.setAdapter(adapter);
        lvDest.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(
                    DestinationListActivity.this,
                    DestinationActivity.class
            );

            intent.putExtra("destination", destinations[position]);
            intent.putExtra("position", position);

            startActivity(intent);
        });

    }
}