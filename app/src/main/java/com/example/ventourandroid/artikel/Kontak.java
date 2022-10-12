package com.example.ventourandroid.artikel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.MyProfile;
import com.example.ventourandroid.Notification;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.SemuaMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Kontak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_VentourAndroid);
        setContentView(R.layout.activity_kontak);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getSupportActionBar().setTitle("Kontak");


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

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(Kontak.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}