package com.example.ventourandroid.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.R;
import com.example.ventourandroid.artikel.Artikel;
import com.example.ventourandroid.artikel.ArtikelDetail;
import com.example.ventourandroid.listpaket.SemuaMenu;

public class UploadBukti extends AppCompatActivity {
    ImageButton backtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_bukti);

        backtoolbar = (ImageButton) findViewById(R.id.go_back);
        backtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(UploadBukti.this, DetailOrder.class);
        startActivity(intent);
        finish();

    }
}