package com.example.ventourandroid.API;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ventourandroid.MainActivity;
import com.example.ventourandroid.R;
import com.example.ventourandroid.listpaket.SemuaMenu;

public class Kiblat extends AppCompatActivity implements SensorEventListener {
    ImageView compass, backtoolbar;
    private static SensorManager sensorManager;
    private static Sensor sensor;
    private float currentDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiblat);

        compass = findViewById(R.id.compas);

        backtoolbar = findViewById(R.id.go_back);
        backtoolbar = (ImageButton) findViewById(R.id.go_back);
        backtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kiblat.this, MainActivity.class);
                startActivity(intent);
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        if (sensor !=null){
            sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_FASTEST);
        }
        else {
            Toast.makeText(getApplicationContext(), "not support", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed()
    {

        Intent intent=new Intent(Kiblat.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int degree = Math.round(sensorEvent.values[0]);
        RotateAnimation animation = new RotateAnimation(currentDegree,-degree, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        compass.setAnimation(animation);
        currentDegree=-degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}