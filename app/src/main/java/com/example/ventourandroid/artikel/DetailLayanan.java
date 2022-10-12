package com.example.ventourandroid.artikel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.ListSemuaPaket;
import com.example.ventourandroid.listpaket.ListUmroh;
import com.example.ventourandroid.listpaket.SemuaMenu;

public class DetailLayanan extends AppCompatActivity implements View.OnClickListener {
    private TextView penerbangan,hotel;
    private Button itinari;
    ImageButton backtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layanan);

        penerbangan = (TextView) findViewById(R.id.list_penerbangan);
        hotel = (TextView) findViewById(R.id.list_hotel);
        itinari = (Button) findViewById(R.id.itinary);
        backtoolbar = (ImageButton)findViewById(R.id.go_back);

        backtoolbar.setOnClickListener(this);
        penerbangan.setOnClickListener(this);
        hotel.setOnClickListener(this);
        itinari.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.list_penerbangan:
                setContentView(R.layout.list_penerbangan);
                break;
            case R.id.list_hotel:
                setContentView(R.layout.list_hotel);
                break;
            case R.id.itinary:
                setContentView(R.layout.list_kegiatan);
                break;
            case R.id.go_back:
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(DetailLayanan.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}