package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView video_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video_view = findViewById(R.id.video_view);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video_view);
        video_view.setMediaController(mediaController);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.androidcommercial);

        video_view.setVideoURI(uri);
        video_view.requestFocus();
        video_view.start();

        getSupportActionBar().hide();
        

    }
}
