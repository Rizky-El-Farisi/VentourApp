package com.example.ventourandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ventourandroid.artikel.DetailLayanan;
import com.example.ventourandroid.controller.DetailOrder;
import com.example.ventourandroid.controller.Login;
import com.example.ventourandroid.controller.UploadBukti;
import com.example.ventourandroid.listpaket.ListTour;
import com.example.ventourandroid.listpaket.SemuaMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyOrder extends AppCompatActivity implements View.OnClickListener {
    private CardView pesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        pesanan = (CardView)findViewById(R.id.pesanan1);
        pesanan.setOnClickListener(this);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.nav_my_order);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_notificarion:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_my_order:
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(),MyProfile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.pesanan1:
                i =new Intent(this, DetailOrder.class);
                startActivity(i);
                break;

        }

    }
    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(MyOrder.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}