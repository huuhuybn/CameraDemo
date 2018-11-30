package vn.edu.poly.camerademo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity {


    private String source = "http://data31.chiasenhac.com/downloads/1974/5/1973435-cbfa9dec/128/Anh%20Dang%20O%20Dau%20Day%20Anh%20-%20Huong%20Giang%20[128kbps_MP3].mp3";
    private Button btnPlay;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        btnPlay = findViewById(R.id.btnPlay);

        // khoi tao mediaPlayer
        mediaPlayer = new MediaPlayer();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    btnPlay.setText("Play");
                    mediaPlayer.pause();

                } else {
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(source);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mediaPlayer.prepare(); // might take long! (for buffering, etc)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                    btnPlay.setText("Playing");
                }


            }
        });

    }


}
