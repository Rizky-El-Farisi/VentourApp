package com.example.ventourandroid.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.MyProfile;
import com.example.ventourandroid.Notification;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.SemuaMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GalleryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //set custom toolbar background
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        //image custom bar start
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.image_toolbar, null);
        actionBar.setCustomView(view);
        //image custom bar end

//        fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        Button btngaleri = findViewById(R.id.gallery);
        btngaleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, GallerykFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        Button btntestimori = findViewById(R.id.testimory);
        btntestimori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, TestimoriFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
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
    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(GalleryActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}