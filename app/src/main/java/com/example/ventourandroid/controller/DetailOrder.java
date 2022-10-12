package com.example.ventourandroid.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ventourandroid.MyOrder;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.ListSemuaPaket;

public class DetailOrder extends AppCompatActivity implements View.OnClickListener{
    Button btn_upload;
    ImageButton backtoolbar;
    TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        btn_upload = (Button)findViewById(R.id.upl_bukti_pembayaran);
        backtoolbar = (ImageButton)findViewById(R.id.go_back);
        edit = (TextView)findViewById(R.id.edit_order);

        backtoolbar.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
        edit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){

            case R.id.upl_bukti_pembayaran:
                i =new Intent(this, UploadBukti.class);
                startActivity(i);
                break;

            case R.id.go_back:
                i =new Intent(this, MyOrder.class);
                startActivity(i);
                break;

            case R.id.edit_order:
                setContentView(R.layout.daftar_type);
                break;
        }

    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(DetailOrder.this, MyOrder.class);
        startActivity(intent);
        finish();

    }
}