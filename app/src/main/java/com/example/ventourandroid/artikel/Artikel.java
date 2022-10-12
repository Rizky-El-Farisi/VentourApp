package com.example.ventourandroid.artikel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.MyProfile;
import com.example.ventourandroid.Notification;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.ListSemuaPaket;
import com.example.ventourandroid.listpaket.SemuaMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Artikel extends AppCompatActivity implements View.OnClickListener {
    private CardView artikel1, artikel2, artikel3;
    ImageButton backtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        artikel1 = (CardView) findViewById(R.id.artikel1);
        artikel2 = (CardView) findViewById(R.id.artikel2);
        artikel3 = (CardView) findViewById(R.id.artikel3);
        backtoolbar = (ImageButton)findViewById(R.id.go_back);

        backtoolbar.setOnClickListener(this);
        artikel1.setOnClickListener(this);
        artikel2.setOnClickListener(this);
        artikel3.setOnClickListener(this);


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
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.artikel1:
                i =new Intent(this, ArtikelDetail.class);
                startActivity(i);
                break;
            case R.id.artikel2:
                i =new Intent(this, ArtikelDetail.class);
                startActivity(i);
                break;
            case R.id.artikel3:
                i =new Intent(this, ArtikelDetail.class);
                startActivity(i);
                break;
            case R.id.go_back:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(Artikel.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}