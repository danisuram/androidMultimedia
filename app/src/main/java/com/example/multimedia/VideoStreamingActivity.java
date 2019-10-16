package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoStreamingActivity extends AppCompatActivity {

    VideoView streamingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);

        streamingView = findViewById(R.id.streamingView);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(streamingView);
        streamingView.setMediaController(mediaController);

//        Uri uri = Uri.parse("https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1");
        Uri uri = Uri.parse("https://www35.zippyshare.com/d/cbB9bHBQ/7673/%5bZ-T%5d_Grease_Cinext_360p.mp4");
//        Uri uri = Uri.parse("https://r4---sn-qxau5-btq6.googlevideo.com/videoplayback?expire=1571220262&ei=xpamXbvAFcqt8gPpnpoo&ip=94.20.62.189&id=o-ADBCYXho9N96IGdzMRQZUEXdTqWCUUrKiyrhbh2gO3gy&itag=22&source=youtube&requiressl=yes&mm=31%2C29&mn=sn-qxau5-btq6%2Csn-nv47ln7l&ms=au%2Crdu&mv=m&mvi=3&pl=24&initcwndbps=12548750&mime=video%2Fmp4&ratebypass=yes&dur=406.442&lmt=1541583623071482&mt=1571198571&fvip=1&fexp=23842630&beids=9466588&c=WEB&txp=5431432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cmime%2Cratebypass%2Cdur%2Clmt&sig=ALgxI2wwRQIgPFlj7t5oz9jWTOAlc2N666aGcMw3kVPOLS3VEVGcvwsCIQCvxWeyfZxtAx9i3SNDwVtP-39Abyqga4rikxlGX9qVvA%3D%3D&lsparams=mm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AHylml4wRgIhAPO7LwkAxpLza0_Yi2lv74gV_QL3vLc5cusHYjqUU68CAiEA4fR-HD2rl5RKxfniRhk6ZMDTWcrnkEGlk4iOhhj0cwc%3D&video_id=d2bMN6Pz6Yw&title=Dreamscape-+Episode+2");

        streamingView.setVideoURI(uri);
        streamingView.requestFocus();

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Harap Tunggu");
        dialog.setCancelable(false);
        dialog.show();

        streamingView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                getSupportActionBar().hide();
                dialog.dismiss();
            }
        });
    }
}
