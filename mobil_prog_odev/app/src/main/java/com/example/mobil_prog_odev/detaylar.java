package com.example.mobil_prog_odev;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detaylar extends AppCompatActivity {
    private ImageView imageViewDrink;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewDrink = findViewById(R.id.imageViewDrink);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String description = extras.getString("description");
            int imageResource = extras.getInt("image");

            textViewName.setText(name);
            textViewDescription.setText(description);
            imageViewDrink.setImageResource(imageResource);
        }
    }
}
