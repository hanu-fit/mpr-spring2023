package edu.hanu.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        MediaPlayer player = MediaPlayer.create(this, R.raw.laugh);
        player.start();
        player.release();
    }
}