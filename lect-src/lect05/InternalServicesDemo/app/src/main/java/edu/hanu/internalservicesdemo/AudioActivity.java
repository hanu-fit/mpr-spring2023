package edu.hanu.internalservicesdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AudioActivity extends AppCompatActivity {

    public static final int AUDIO_CAPTURED = 1;

    private Uri audioUri;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
    }

    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnRecord:
                Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivityForResult(intent, AUDIO_CAPTURED);
                break;

            case R.id.btnPlay:
                if (audioUri != null) {
                    mediaPlayer = MediaPlayer.create(this, audioUri);
                    mediaPlayer.start();
                }
                break;

            case R.id.btnStop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == AUDIO_CAPTURED) {
            audioUri = data.getData();
        }
    }
}