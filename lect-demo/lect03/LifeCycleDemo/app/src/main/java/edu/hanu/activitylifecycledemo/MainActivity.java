package edu.hanu.activitylifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MPR", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("MPR", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("MPR", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("MPR", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("MPR", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MPR", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("MPR", "onRestart()");
    }
}