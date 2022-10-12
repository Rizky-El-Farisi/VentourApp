package com.example.ventourandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ventourandroid.API.AlquranActivity;
import com.example.ventourandroid.API.JadwalSholat;
import com.example.ventourandroid.adapter.SliderPagerAdapter;
import com.example.ventourandroid.artikel.Artikel;
import com.example.ventourandroid.artikel.ArtikelDetail;
import com.example.ventourandroid.artikel.DetailLayanan;
import com.example.ventourandroid.decoration.BannerSlider;
import com.example.ventourandroid.decoration.FragmentSlider;
import com.example.ventourandroid.decoration.SliderIndicator;
import com.example.ventourandroid.listpaket.ListHaji;
import com.example.ventourandroid.listpaket.ListSemuaPaket;
import com.example.ventourandroid.listpaket.ListTour;
import com.example.ventourandroid.listpaket.ListUmroh;
import com.example.ventourandroid.listpaket.SemuaMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CardView umroh, muslim_tour, haji, alquran, waktusholat, moremenu, paket, artikel;
    TextView artikel_list;
    ImageButton semuapaket;

    private boolean isBackPressedOnce = false;

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_VentourAndroid);
        setContentView(R.layout.activity_main);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getSupportActionBar().setDisplayShowCustomEnabled(false);


        bannerSlider = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();

        umroh = (CardView) findViewById(R.id.umroh);
        muslim_tour = (CardView) findViewById(R.id.muslim_tour);
        haji = (CardView) findViewById(R.id.haji);
        alquran = (CardView) findViewById(R.id.alquran);
        waktusholat = (CardView) findViewById(R.id.waktu_sholat);
        moremenu = (CardView) findViewById(R.id.more_menu);
        artikel_list = (TextView)findViewById(R.id.list_artikel);
        paket = (CardView)findViewById(R.id.paket1);
        artikel = (CardView)findViewById(R.id.artikel_list1);
        semuapaket = (ImageButton) findViewById(R.id.semuapaket);

        umroh.setOnClickListener(this);
        muslim_tour.setOnClickListener(this);
        haji.setOnClickListener(this);
        alquran.setOnClickListener(this);
        waktusholat.setOnClickListener(this);
        moremenu.setOnClickListener(this);
        artikel_list.setOnClickListener(this);
        paket.setOnClickListener(this);
        artikel.setOnClickListener(this);
        semuapaket.setOnClickListener(this);


        //pop up modal funtion start
//        moremenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupModal popupModal = new PopupModal();
//                popupModal.show(getSupportFragmentManager(), "tag");
//
//            }
//        });
        //pop up modal funtion end

        //image custom bar start
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.image_toolbar, null);
        actionBar.setCustomView(view);
        //image custom bar end

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
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_my_order:
                        startActivity(new Intent(getApplicationContext(),MyOrder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(),MyProfile.class));
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
            case R.id.umroh:
                i =new Intent(this, ListUmroh.class);
                startActivity(i);
                break;

            case R.id.muslim_tour:
                i =new Intent(this, ListTour.class);
                startActivity(i);
                break;

            case R.id.haji:
                i =new Intent(this, ListHaji.class);
                startActivity(i);
                break;

            case R.id.alquran:
                i =new Intent(this, AlquranActivity.class);
                startActivity(i);
                break;

            case R.id.waktu_sholat:
                i =new Intent(this, JadwalSholat.class);
                startActivity(i);
                break;

            case R.id.more_menu:
                i =new Intent(this, SemuaMenu.class);
                startActivity(i);
                break;

            case R.id.list_artikel:
                i =new Intent(this, Artikel.class);
                startActivity(i);
                break;

            case R.id.paket1:
                i =new Intent(this, DetailLayanan.class);
                startActivity(i);
                break;

            case R.id.artikel_list1:
                i =new Intent(this, ArtikelDetail.class);
                startActivity(i);
                break;

            case R.id.semuapaket:
                i =new Intent(this, ListSemuaPaket.class);
                startActivity(i);
                break;
        }
    }

    //setup slider for banner start
    private void setupSlider() {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://www.ventour.co.id/wp-content/uploads/2021/08/banner-website-VENTOUR-resize.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.ventour.co.id/wp-content/uploads/2022/03/Home-Banner-Menabung-Umrah-ver2-01.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.ventour.co.id/wp-content/uploads/2022/02/umrohproven.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.ventour.co.id/wp-content/uploads/2022/03/Home-Banner-Umrah-Menjelang-Ramadhan-1.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
    //setup slider for banner end

    //setup back button double klik to exit start
    @Override
    public void onBackPressed() {

        if (isBackPressedOnce){
            super.onBackPressed();
            return;
        }

        Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();
        isBackPressedOnce = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isBackPressedOnce = false;
            }
        }, 2000);finish();
    }
    //setup back button double klik to exit end

}
