package com.example.ventourandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ventourandroid.controller.Login;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyProfile extends AppCompatActivity implements View.OnClickListener{
    private Button logout;
    private TextView ktp;
    private ImageButton identitas, document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        ktp = (TextView) findViewById(R.id.edit_KTP_profile);
        identitas = (ImageButton) findViewById(R.id.upl_identitas_profile);
        document = (ImageButton) findViewById(R.id.upl_document_profile);
        logout = (Button) findViewById(R.id.keluar_akun);

        ktp.setOnClickListener(this);
        identitas.setOnClickListener(this);
        document.setOnClickListener(this);
        logout.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);

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
                        startActivity(new Intent(getApplicationContext(),MyOrder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_profile:
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(MyProfile.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.keluar_akun:
                i = new Intent(this, Login.class);
                startActivity(i);
                break;

            case R.id.edit_KTP_profile:
                setContentView(R.layout.identitas_diri);
                break;

            case R.id.upl_document_profile:
                setContentView(R.layout.upload_document);
                break;

            case R.id.upl_identitas_profile:
                setContentView(R.layout.identitas_diri);
                break;
        }
    }
}