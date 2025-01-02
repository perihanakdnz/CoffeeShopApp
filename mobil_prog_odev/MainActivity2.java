package com.example.mobil_prog_odev;

import static com.example.mobil_prog_odev.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ListView lstv = findViewById(id.listview);
        
        // Veritabanı örneğini al
        db = AppDatabase.getInstance(this);

        // İlk kez çalıştığında verileri ekle
        if (db.drinkDao().getAllDrinks().isEmpty()) {
            insertInitialData();
        }

        // Verileri veritabanından çek
        List<Drink> drinkList = db.drinkDao().getAllDrinks();

        // Verileri dizilere dönüştür
        String[] ad = new String[drinkList.size()];
        int[] resim = new int[drinkList.size()];

        for (int i = 0; i < drinkList.size(); i++) {
            Drink drink = drinkList.get(i);
            ad[i] = drink.getName();
            resim[i] = drink.getImageResource();
        }

        CustomAdapter adap = new CustomAdapter(resim, ad, this);
        lstv.setAdapter(adap);

        lstv.setOnItemClickListener((parent, view, position, id) -> {
            Drink selectedDrink = drinkList.get(position);
            Intent intent = new Intent(MainActivity2.this, DetailActivity.class);
            intent.putExtra("name", selectedDrink.getName());
            intent.putExtra("description", selectedDrink.getDescription());
            intent.putExtra("image", selectedDrink.getImageResource());
            startActivity(intent);
        });
    }

    private void insertInitialData() {
        Drink[] drinks = {
            new Drink("Americano", drawable.americano, 
                "Americano, espresso ve sıcak su karışımıyla hazırlanan bir kahve çeşididir."),
            new Drink("Espresso", drawable.espresso,
                "Espresso, yüksek basınçla hazırlanan yoğun İtalyan kahvesidir."),
            new Drink("Latte", drawable.latte,
                "Latte, espresso ve buharla ısıtılmış süt ile hazırlanan kremamsı bir içecektir."),
            new Drink("Mocha", drawable.mocha,
                "Mocha, espresso, sıcak süt ve çikolata karışımından oluşan tatlı bir içecektir."),
            new Drink("Türk Kahvesi", drawable.turk_kahvesi,
                "Geleneksel Türk kahvesi, özel cezvelerde pişirilir ve köpüklü servis edilir."),
            new Drink("Filtre Kahve", drawable.filtre_kahve,
                "Filtre kahve, öğütülmüş kahve çekirdeklerinin sıcak su ile damıtılmasıyla hazırlanır."),
            new Drink("Cool Lime", drawable.cool_lime,
                "Cool Lime, ferahlatıcı lime ve nane karışımı serinletici bir içecektir."),
            new Drink("Cold Brew", drawable.cold_brew,
                "Cold Brew, kahvenin soğuk demleme yöntemiyle hazırlandığı yumuşak içimli bir içecektir.")
        };
        db.drinkDao().insertAll(drinks);
    }
} 