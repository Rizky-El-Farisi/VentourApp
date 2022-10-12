package com.example.ventourandroid.artikel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.ventourandroid.API.Doa;
import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.MyProfile;
import com.example.ventourandroid.Notification;
import com.example.ventourandroid.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ArtikelDetail extends AppCompatActivity {
    ImageButton backtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_detail);

        backtoolbar = (ImageButton) findViewById(R.id.go_back);
        backtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //navigation view start
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_notificarion:
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_my_order:
                        startActivity(new Intent(getApplicationContext(), MyOrder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), MyProfile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        //navigation view end
    }
}