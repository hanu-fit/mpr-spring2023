package edu.hanu.internalservicesdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

import edu.hanu.internalservicesdemo.adapters.SensorAdapter;

public class SensorRVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_rvactivity);

        RecyclerView rvSensors = findViewById(R.id.rvSensors);
        rvSensors.setLayoutManager(new LinearLayoutManager(this));

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        SensorAdapter sensorAdapter = new SensorAdapter(sensors);
        rvSensors.setAdapter(sensorAdapter);
    }
}