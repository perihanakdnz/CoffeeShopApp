package com.example.mobil_prog_odev;

import static com.example.mobil_prog_odev.R.id.img;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        if (isInternetAvailable()) {
            Toast.makeText(this, "İnternete bağlandı", Toast.LENGTH_SHORT).show();
            
            ImageView img;
            img = findViewById(R.id.img);
            Button btn = findViewById(R.id.btn);
            Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animasyon);
            img.startAnimation(anim);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent git = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(git);
                }
            });
        } else {
            Toast.makeText(this, "İnternet bağlantısı yok! Lütfen internet bağlantınızı kontrol edin.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
} 