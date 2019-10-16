package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnPause, btnResume, btnStop, btnVideo, btnStreaming;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnStop = findViewById(R.id.btnStop);
        btnVideo = findViewById(R.id.btnVideo);
        btnStreaming = findViewById(R.id.btnStreaming);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnResume.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        btnStreaming.setOnClickListener(this);

        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnResume.setEnabled(false);
        btnStop.setEnabled(false);


    }

    @Override
    protected void onPause() {
        super.onPause();

        if(player == null){
            Toast.makeText(this,"MainActivity onPause", Toast.LENGTH_SHORT).show();
        }
        else if(player.isPlaying()){
            player.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(player != null){
            player.start();
        }

        Toast.makeText(this,"MainActivity onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(player == null){
            Toast.makeText(this,"MainActivity onDestroy", Toast.LENGTH_SHORT).show();
        }else if(player.isPlaying() && player != null){
            player.stop();
        }

    }



    @Override
    public void onClick(View view) {

        int id = view.getId();

        if( id == R.id.btnPlay){
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.music);

            try {
                player.setDataSource(MainActivity.this, uri);
                player.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.start();

            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            btnResume.setEnabled(false);
            btnStop.setEnabled(true);


        }
        if ( id == R.id.btnPause){
            if(player.isPlaying()){
                player.pause();
            }

            btnPlay.setEnabled(false);
            btnPause.setEnabled(false);
            btnResume.setEnabled(true);
            btnStop.setEnabled(false);

        }

        if (id == R.id.btnResume){
            player.start();

            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            btnResume.setEnabled(false);
            btnStop.setEnabled(true);

        }

        if (id == R.id.btnStop){
            if(player.isPlaying() && player != null){
                player.stop();
            }

            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
            btnResume.setEnabled(false);
            btnStop.setEnabled(false);

        }

        if (id == R.id.btnVideo){
            startActivity(new Intent(MainActivity.this, VideoActivity.class));
        }

        if(id == R.id.btnStreaming){
            startActivity(new Intent(MainActivity.this, VideoStreamingActivity.class));
        }

    }
}
