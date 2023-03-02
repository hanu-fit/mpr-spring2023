package edu.hanu.internalservicesdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    public static final int VIDEO_CAPTURED = 2;

    private VideoView videoView;
    private Uri videoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
    }

    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnRecord:
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, VIDEO_CAPTURED);
                break;

            case R.id.btnPlay:
                if (videoUri != null) {
                    videoView.setVideoURI(videoUri);
                    videoView.start();
                }
                break;

            case R.id.btnStop:
                videoView.stopPlayback();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == VIDEO_CAPTURED) {
            videoUri = data.getData();
        }
    }
}