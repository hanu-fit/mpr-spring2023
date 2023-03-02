package edu.hanu.internalservicesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent intent = null;

        switch(view.getId()) {
            case R.id.btnAudio:
                intent = new Intent(this, AudioActivity.class);
                break;

            case R.id.btnVideo:
                intent = new Intent(this, VideoActivity.class);
                break;

            case R.id.btnCamera:
                intent = new Intent(this, ImageActivity.class);
                break;

            case R.id.btnSensor:
                intent = new Intent(this, SensorRVActivity.class);
                break;
        }

        startActivity(intent);
    }
}