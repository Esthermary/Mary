package com.example.esther;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class music extends AppCompatActivity {
    Button btnplay;
    MediaPlayer play;
    Button btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        btnplay=findViewById(R.id.btnplay);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play=MediaPlayer.create(getApplicationContext(),R.raw.enyanda);
                play.start();
            }
            });
        btnstop=findViewById(R.id.btnstop);
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(play !=null && play.isPlaying())
                play.stop();
            }
        });

        }

    }
