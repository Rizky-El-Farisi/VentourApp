package com.example.ventourandroid.listpaket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ventourandroid.API.AlquranActivity;
import com.example.ventourandroid.API.Doa;
import com.example.ventourandroid.API.JadwalSholat;
import com.example.ventourandroid.API.Kiblat;
import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.R;
import com.example.ventourandroid.artikel.Artikel;
import com.example.ventourandroid.artikel.Kontak;
import com.example.ventourandroid.gallery.GalleryActivity;

public class SemuaMenu extends AppCompatActivity implements View.OnClickListener {
    public CardView umroh, muslim_tour, haji, alquran, waktusholat, moremenu, semuapaket, galeri, artikel, kiblat, doa, kontak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semua_menu);

        umroh = (CardView) findViewById(R.id.umroh);
        muslim_tour = (CardView) findViewById(R.id.muslim_tour);
        haji = (CardView) findViewById(R.id.haji);
        alquran = (CardView) findViewById(R.id.alquran);
        waktusholat = (CardView) findViewById(R.id.waktu_sholat);
//        moremenu = (CardView) findViewById(R.id.more_menu);
        semuapaket = (CardView) findViewById(R.id.semuapaket);
        galeri = (CardView) findViewById(R.id.galeri_page);
        artikel = (CardView) findViewById(R.id.artikel);
        kiblat = (CardView) findViewById(R.id.kiblat);
        doa = (CardView) findViewById(R.id.doa);
        kontak = (CardView) findViewById(R.id.kontak_kami);


        umroh.setOnClickListener(this);
        muslim_tour.setOnClickListener(this);
        haji.setOnClickListener(this);
        alquran.setOnClickListener(this);
        waktusholat.setOnClickListener(this);
        semuapaket.setOnClickListener(this);
        galeri.setOnClickListener(this);
        artikel.setOnClickListener(this);
        kiblat.setOnClickListener(this);
        doa.setOnClickListener(this);
        kontak.setOnClickListener(this);


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

            case R.id.semuapaket:
                i =new Intent(this, ListSemuaPaket.class);
                startActivity(i);
                break;


            case R.id.galeri_page:
                i =new Intent(this, GalleryActivity.class);
                startActivity(i);
                break;

            case R.id.kiblat:
                i =new Intent(this, Kiblat.class);
                startActivity(i);
                break;

            case R.id.artikel:
                i =new Intent(this, Artikel.class);
                startActivity(i);
                break;

            case R.id.doa:
                i = new Intent(this , Doa.class);
                startActivity(i);
                break;


            case R.id.kontak_kami:
                i =new Intent(this, Kontak.class);
                startActivity(i);
                break;
        }

    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(SemuaMenu.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}