package com.example.ventourandroid.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.SemuaMenu;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button btn_jamaah, btn_login_konsultan, btn_consultan, btn_login_jamaah;
    TextView register, reg_jamaah, reg_konsultan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_consultan = (Button) findViewById(R.id.login_pilih_consultan);
        btn_jamaah = (Button) findViewById(R.id.login_pilih_jamaah);
        btn_login_jamaah = (Button) findViewById(R.id.login_jamaah_button);
        btn_login_konsultan = (Button) findViewById(R.id.login_consultan_button);
        register = (TextView) findViewById(R.id.daftar_akun);
        reg_jamaah = (TextView) findViewById(R.id.daftar_akun_jamaah);
        reg_konsultan = (TextView) findViewById(R.id.daftar_akun_konsultan);

        btn_consultan.setOnClickListener(this);
//        btn_login_konsultan.setOnClickListener(this);
        btn_jamaah.setOnClickListener(this);
//        btn_login_jamaah.setOnClickListener(this);
        register.setOnClickListener(this);
//        reg_konsultan.setOnClickListener(this);
//        reg_jamaah.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.login_pilih_consultan:
                setContentView(R.layout.login_konsultan);
                break;
            case R.id.login_pilih_jamaah:
                setContentView(R.layout.login_jamaah);
                break;
//            case R.id.login_consultan_button:
//                setContentView(R.layout.blank_layout);
//                break;
            case R.id.login_jamaah_button:
                setContentView(R.layout.activity_main);
                break;
            case R.id.daftar_akun:
                setContentView(R.layout.register);
                break;
//            case R.id.daftar_akun_jamaah:
//                setContentView(R.layout.blank_layout);
//                break;
//            case R.id.daftar_akun_konsultan:
//                setContentView(R.layout.blank_layout);
//                break;

        }

    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}