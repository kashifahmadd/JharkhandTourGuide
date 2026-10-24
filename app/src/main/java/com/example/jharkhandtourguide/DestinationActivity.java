package com.example.jharkhandtourguide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class DestinationActivity extends AppCompatActivity {
    private TextView tvDestName, tvDestInfo;
    private ImageView ivDestination;
    private Button btnSave;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private int[] images = {
            R.drawable.baba_baidyanath,
            R.drawable.dassam_falls,
            R.drawable.jubilee_park,
            R.drawable.parasnath_hills,
            R.drawable.maithon_dam,
            R.drawable.patratu_valley,
            R.drawable.rock_garden,
            R.drawable.hundru_falls,
            R.drawable.jonha_falls,
            R.drawable.dimna_lake,
            R.drawable.jagannath_mandir,
            R.drawable.yogoda_satsanga,
            R.drawable.trikuta_parvata,
            R.drawable.basukinath_temple,
            R.drawable.dalma_wildlife_sanctuary,
            R.drawable.bhatinda_fall,
            R.drawable.rajrappa_temple,
            R.drawable.netarhat,
            R.drawable.birsa_zoological_park,
            R.drawable.jrd_tata_sports_complex,
            R.drawable.massanjore_dam,
            R.drawable.naulakha_mandir,
            R.drawable.tata_steel_zoological_park,
            R.drawable.usri_falls,
            R.drawable.hirni_water_falls,
            R.drawable.topchanchi_wildlife_sanctuary,
            R.drawable.betla_national_park
    };
    private String[] locations = {
            "Deoghar",
            "Ranchi",
            "Jamshedpur",
            "Giridih",
            "Dhanbad",
            "Ramgarh",
            "Ranchi",
            "Ranchi",
            "Ranchi",
            "Jamshedpur",
            "Ranchi",
            "Ranchi",
            "Deoghar",
            "Dumka",
            "East Singhbhum",
            "Dhanbad",
            "Ramgarh",
            "Latehar",
            "Ranchi",
            "Jamshedpur",
            "Pakur",
            "Deoghar",
            "Jamshedpur",
            "Giridih",
            "Ranchi",
            "Dhanbad",
            "Latehar"
    };

    private String[] categories = {
            "Temple & Pilgrimage",
            "Waterfall & Nature",
            "Park & Recreation",
            "Hill & Pilgrimage",
            "Dam & Nature",
            "Valley & Scenic",
            "Garden & Viewpoint",
            "Waterfall & Nature",
            "Waterfall & Nature",
            "Lake & Nature",
            "Temple & Heritage",
            "Meditation & Spiritual",
            "Hill & Adventure",
            "Temple & Pilgrimage",
            "Wildlife & Nature",
            "Waterfall & Nature",
            "Temple & Pilgrimage",
            "Hill Station & Nature",
            "Zoo & Wildlife",
            "Sports & Recreation",
            "Dam & Nature",
            "Temple & Heritage",
            "Zoo & Wildlife",
            "Waterfall & Nature",
            "Waterfall & Nature",
            "Wildlife & Nature",
            "National Park & Wildlife"
    };
    private String[] information = {

            "Summary: One of the most important pilgrimage destinations in Jharkhand.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Baba Baidyanath Temple is one of the twelve traditionally recognized Jyotirlingas of Lord Shiva.\n\n"
                    + "What you can expect: A spiritually significant temple complex, traditional religious practices and a lively pilgrimage atmosphere.\n\n"
                    + "Cultural & historical facts: Deoghar has been an important pilgrimage centre for centuries and is closely associated with the Kanwar pilgrimage.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A spectacular waterfall created by the Kanchi River near Ranchi.\n\n"
                    + "Rating: 4.7/5\n\n"
                    + "Why it is famous: Dassam Falls is known for its beautiful cascade surrounded by greenery and rocky terrain.\n\n"
                    + "What you can expect: Scenic views, flowing water, greenery and a popular weekend destination near Ranchi.\n\n"
                    + "Cultural & historical facts: The waterfall is also known locally as Dassam Ghagh and is one of the important natural attractions of the Ranchi region.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A large recreational park in the heart of Jamshedpur.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Jubilee Park is known for its gardens, fountains, open spaces and beautifully maintained landscape.\n\n"
                    + "What you can expect: Greenery, walking areas, fountains and a relaxing environment for families and visitors.\n\n"
                    + "Cultural & historical facts: The park was developed by Tata Steel and is an important recreational landmark of Jamshedpur.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A prominent hill range and important pilgrimage landscape in Jharkhand.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Parasnath Hills are especially sacred to Jainism and are associated with important Jain pilgrimage sites.\n\n"
                    + "What you can expect: Hills, forests, temples and a peaceful pilgrimage environment.\n\n"
                    + "Cultural & historical facts: The highest point is associated with Sammed Shikharji, where many Jain Tirthankaras are traditionally believed to have attained liberation.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A major dam and reservoir located on the Barakar River.\n\n"
                    + "Rating: 4.4/5\n\n"
                    + "Why it is famous: Maithon Dam is known for its large reservoir, surrounding hills and scenic landscape.\n\n"
                    + "What you can expect: Wide water views, greenery, hills and a peaceful environment.\n\n"
                    + "Cultural & historical facts: Maithon Dam is part of the Damodar Valley Corporation's network of multipurpose projects.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic valley surrounded by green hills near Patratu.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Patratu Valley is particularly popular for its winding roads, hill views and picturesque landscape.\n\n"
                    + "What you can expect: Mountain views, scenic roads, fresh air and beautiful viewpoints.\n\n"
                    + "Cultural & historical facts: The area developed alongside Patratu's industrial and power infrastructure and has become an important scenic destination.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A landscaped attraction built around natural rock formations in Ranchi.\n\n"
                    + "Rating: 4.3/5\n\n"
                    + "Why it is famous: Rock Garden combines natural rock formations with landscaped areas and viewpoints.\n\n"
                    + "What you can expect: Interesting rock structures, gardens, walking areas and views of the surrounding landscape.\n\n"
                    + "Cultural & historical facts: It is one of Ranchi's well-known recreational attractions and is located near Kanke Dam.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: One of the most famous waterfalls in Jharkhand.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Hundru Falls is formed by the Subarnarekha River and drops dramatically over a rocky landscape.\n\n"
                    + "What you can expect: A powerful waterfall, rocky surroundings, greenery and impressive views, especially during the monsoon.\n\n"
                    + "Cultural & historical facts: Hundru Falls is one of the signature natural landmarks associated with Ranchi and the Chota Nagpur Plateau.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic waterfall on the Raru River near Ranchi.\n\n"
                    + "Rating: 4.6/5\n\n"
                    + "Why it is famous: Jonha Falls is known for its forested surroundings and beautiful cascade.\n\n"
                    + "What you can expect: A peaceful natural setting, waterfall views and a refreshing escape from the city.\n\n"
                    + "Cultural & historical facts: The waterfall is also known as Gautamdhara and has associations with local religious traditions.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic reservoir surrounded by the Dalma hills near Jamshedpur.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Dimna Lake is known for its peaceful water views and natural surroundings.\n\n"
                    + "What you can expect: Lakeside scenery, hills, greenery and a relaxing outdoor atmosphere.\n\n"
                    + "Cultural & historical facts: The reservoir was developed to support Jamshedpur's water requirements and later became a popular recreational destination.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A historic temple dedicated to Lord Jagannath in Ranchi.\n\n"
                    + "Rating: 4.6/5\n\n"
                    + "Why it is famous: The temple is known for its elevated location, traditional architecture and annual Rath Yatra.\n\n"
                    + "What you can expect: Temple architecture, religious ceremonies and panoramic views from the hilltop.\n\n"
                    + "Cultural & historical facts: The temple's Rath Yatra is an important cultural and religious event in Ranchi.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A peaceful spiritual and meditation centre in Ranchi.\n\n"
                    + "Rating: 4.3/5\n\n"
                    + "Why it is famous: Yogoda Satsanga Dhyana Mandir is associated with meditation, yoga and spiritual practices.\n\n"
                    + "What you can expect: A calm atmosphere suitable for reflection, meditation and learning about spiritual traditions.\n\n"
                    + "Cultural & historical facts: Yogoda Satsanga is associated with the spiritual tradition of Paramahansa Yogananda and the teachings of Kriya Yoga.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic hill destination near Deoghar.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Trikuta Parvata is known for its hills, natural surroundings and views of the surrounding landscape.\n\n"
                    + "What you can expect: Hill scenery, religious significance and an aerial ropeway experience.\n\n"
                    + "Cultural & historical facts: The hills are associated with local religious traditions and are an important attraction around Deoghar.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: An important Shiva temple in Dumka district.\n\n"
                    + "Rating: 4.7/5\n\n"
                    + "Why it is famous: Basukinath Temple is a major pilgrimage destination and is traditionally associated with the pilgrimage to Baba Baidyanath Temple.\n\n"
                    + "What you can expect: Temple architecture, religious rituals and a strong pilgrimage atmosphere.\n\n"
                    + "Cultural & historical facts: The temple is an important part of the religious circuit connecting Basukinath with Deoghar.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A protected forest area spread across the Dalma hills.\n\n"
                    + "Rating: 4.6/5\n\n"
                    + "Why it is famous: Dalma Wildlife Sanctuary is particularly known for its elephant population and forest ecosystem.\n\n"
                    + "What you can expect: Forest landscapes, wildlife, hills and opportunities for nature observation.\n\n"
                    + "Cultural & historical facts: The sanctuary forms an important part of the natural landscape around Jamshedpur and supports diverse wildlife.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic waterfall located near Dhanbad.\n\n"
                    + "Rating: 4.2/5\n\n"
                    + "Why it is famous: Bhatinda Fall is known for its rocky landscape, flowing water and greenery.\n\n"
                    + "What you can expect: A natural setting suitable for sightseeing, photography and spending time outdoors.\n\n"
                    + "Cultural & historical facts: It is one of the locally popular natural attractions around Dhanbad.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A major pilgrimage centre at the meeting point of two rivers.\n\n"
                    + "Rating: 4.7/5\n\n"
                    + "Why it is famous: Rajrappa is famous for the Chhinnamasta Temple, dedicated to Goddess Chhinnamasta.\n\n"
                    + "What you can expect: Temple visits, religious rituals and the scenic confluence of the Damodar and Bhairavi rivers.\n\n"
                    + "Cultural & historical facts: The temple is an important Shakti pilgrimage site and has deep religious significance in the region.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A beautiful hill station known for its forests and pleasant climate.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Netarhat is popularly known for its sunsets, viewpoints, forests and cool climate.\n\n"
                    + "What you can expect: Scenic hills, peaceful surroundings, sunrise and sunset viewpoints and forest landscapes.\n\n"
                    + "Cultural & historical facts: Netarhat developed as a hill retreat during the colonial period and later became an important educational and tourism centre.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A popular zoological park near Ranchi.\n\n"
                    + "Rating: 4.4/5\n\n"
                    + "Why it is famous: Birsa Zoological Park provides an opportunity to see different species of animals and birds.\n\n"
                    + "What you can expect: Animal enclosures, greenery and an educational outing suitable for families.\n\n"
                    + "Cultural & historical facts: The park is named after Birsa Munda, one of Jharkhand's most important historical figures.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A major sports complex in Jamshedpur.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: JRD Tata Sports Complex is an important sporting venue and has hosted major sporting events.\n\n"
                    + "What you can expect: Modern sports facilities and a glimpse of Jamshedpur's strong sporting culture.\n\n"
                    + "Cultural & historical facts: The complex is named after J. R. D. Tata and reflects Tata's long association with sports development in Jamshedpur.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A distinctive historic temple in Deoghar.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Naulakha Mandir is known for its architectural design and spiritual significance.\n\n"
                    + "What you can expect: A peaceful temple environment and an opportunity to appreciate its distinctive architecture.\n\n"
                    + "Cultural & historical facts: The temple was built in the early twentieth century and is associated with Radha-Krishna worship.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A cultural and educational centre in Jamshedpur.\n\n"
                    + "Rating: 4.3/5\n\n"
                    + "Why it is famous: The centre showcases aspects of art, culture, science and the industrial heritage associated with Tata Steel.\n\n"
                    + "What you can expect: Exhibitions, educational displays and an insight into the city's industrial and cultural development.\n\n"
                    + "Cultural & historical facts: It is named after Russi M. Modi, a prominent former chairman of Tata Steel.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A ropeway experience connecting visitors to the Trikut hills near Deoghar.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: The ropeway provides an aerial view of the hills and surrounding landscape.\n\n"
                    + "What you can expect: A scenic cable-car journey, hill views and an adventurous experience.\n\n"
                    + "Cultural & historical facts: Trikut is also associated with local religious traditions and is an important attraction in the Deoghar region.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A zoological park located in Jamshedpur.\n\n"
                    + "Rating: 4.4/5\n\n"
                    + "Why it is famous: Tata Steel Zoological Park is known for its animal and bird collections and green surroundings.\n\n"
                    + "What you can expect: Wildlife viewing, landscaped areas and a family-friendly outdoor experience.\n\n"
                    + "Cultural & historical facts: The park reflects Tata Steel's contribution to recreational and environmental development in Jamshedpur.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A beautiful waterfall near Giridih.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Usri Falls is created by the Usri River flowing through rocky terrain.\n\n"
                    + "What you can expect: Waterfall views, rocky surroundings, greenery and a peaceful natural atmosphere.\n\n"
                    + "Cultural & historical facts: It is one of Giridih's best-known natural attractions and an important part of the region's tourism.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic viewpoint famous for its sunset near Netarhat.\n\n"
                    + "Rating: 4.6/5\n\n"
                    + "Why it is famous: Magnolia Point is known for panoramic views and beautiful sunsets over the surrounding hills and forests.\n\n"
                    + "What you can expect: Wide valley views, cool hill-station surroundings and a memorable sunset experience.\n\n"
                    + "Cultural & historical facts: The viewpoint is associated with the popular local story of Magnolia and is one of Netarhat's best-known tourist spots.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A scenic waterfall surrounded by forests near Ranchi.\n\n"
                    + "Rating: 4.5/5\n\n"
                    + "Why it is famous: Hirni Water Falls is known for its natural beauty, forest surroundings and cascading water.\n\n"
                    + "What you can expect: Green landscapes, waterfall views and a peaceful escape into nature.\n\n"
                    + "Cultural & historical facts: The waterfall is located in the forested landscape of western Ranchi district and is an important local tourism attraction.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: A protected natural area around Topchanchi Lake and its surrounding forests.\n\n"
                    + "Rating: 4.4/5\n\n"
                    + "Why it is famous: Topchanchi is known for its lake, forest landscape and natural surroundings.\n\n"
                    + "What you can expect: Scenic lake views, greenery and opportunities to enjoy a quieter natural environment.\n\n"
                    + "Cultural & historical facts: Topchanchi became an important water-resource area and is now also recognized as a natural and recreational destination.\n\n"
                    + "Thank you for exploring Jharkhand.",

            "Summary: One of Jharkhand's best-known national parks and wildlife destinations.\n\n"
                    + "Rating: 4.8/5\n\n"
                    + "Why it is famous: Betla National Park is known for its forests, elephants, deer, bison and other wildlife.\n\n"
                    + "What you can expect: Forest landscapes, wildlife sightings, nature trails and opportunities for a safari experience.\n\n"
                    + "Cultural & historical facts: Betla is part of the Palamau Tiger Reserve landscape and is one of the major protected areas of Jharkhand.\n\n"
                    + "Thank you for exploring Jharkhand."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_destination);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDestName = findViewById(R.id.tvDestName);
        tvDestInfo = findViewById(R.id.tvDestInfo);
        ivDestination = findViewById(R.id.ivDestination);
        ivDestination.setImageResource(R.drawable.hundru_falls);
        btnSave = findViewById(R.id.btnSave);

        sp = getSharedPreferences("saved_places", MODE_PRIVATE);
        editor = sp.edit();


        String destination = getIntent().getStringExtra("destination");

        int position = getIntent().getIntExtra("position", 0);


        ivDestination.setImageResource(images[position]);

        tvDestName.setText(destination);

        tvDestName.setText(destination);

        tvDestInfo.setText(
                "Location: " + locations[position]
                        + "\n\nCategory: " + categories[position]
                        + "\n\n" + information[position]
        );
        btnSave.setOnClickListener(v -> {
            editor.putBoolean(destination,true);
            editor.commit();
            Snackbar.make(v,"Place Saved", Snackbar.LENGTH_LONG).show();
        });
    }
}