package com.ifsc.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sm;
    Spinner listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sm.getSensorList(Sensor.TYPE_ALL);
        Spinner listar = (Spinner) findViewById(R.id.ListSensor);
        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, deviceSensors);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listar.setAdapter(dataAdapter);

    }

    public void AceleClick(View v) {
        Intent i = new Intent(MainActivity.this, AcceleActivity.class);
        startActivity(i);
    }

    public void GyroClick(View v) {
        Intent i = new Intent(MainActivity.this, GyroActivity.class);
        startActivity(i);
    }

}