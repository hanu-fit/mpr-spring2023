package edu.hanu.animationsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get image ref
        ImageView imvBart = findViewById(R.id.imvBart);

        // animate
//        imvBart.animate().alpha(0).setDuration(2000); // fade
//        imvBart.animate().translationYBy(1000f).setDuration(2000); // move down
//        imvBart.animate().translationXBy(-1000f).setDuration(2000); // move left
//        imvBart.animate().rotation(180).setDuration(2000); // clock wise
//        imvBart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000); // zoom out

    }
}