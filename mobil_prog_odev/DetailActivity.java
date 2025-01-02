package com.example.mobil_prog_odev;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageViewDrink;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // View'ları doğru ID'lerle tanımlama
        imageViewDrink = findViewById(R.id.imageViewDrink);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        // Intent'ten gelen verileri alma
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String description = extras.getString("description");
            int imageResource = extras.getInt("image");

            // Verileri view'lara yerleştirme
            textViewName.setText(name);
            textViewDescription.setText(description);
            imageViewDrink.setImageResource(imageResource);
        }
    }
} 