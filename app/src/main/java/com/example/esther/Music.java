package com.example.esther;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity implements View.OnClickListener {
    Button buttonStart, buttonStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        buttonStart = findViewById(R.id.btnplay);
        buttonStop = findViewById(R.id.btnstop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnplay:
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.btnstop:
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this, MusicService.class));
    }
}