package com.thaivantrung.thigk2_thaivantrung;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_currency) {
                startActivity(new Intent(this, ChucNang1Activity.class));
            } else if (id == R.id.nav_songs) {
                startActivity(new Intent(this, ChucNang2Activity.class));
            } else if (id == R.id.nav_heroes) {
                startActivity(new Intent(this, ChucNang3Activity.class));
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ChucNang4Activity.class));
            }
            return true;
        });
    }
}