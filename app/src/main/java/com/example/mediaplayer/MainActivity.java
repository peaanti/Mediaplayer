package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private MediaPlayer mp;
    private SeekBar sb;
    ImageButton imageButton;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.song);
        imageButton = findViewById(R.id.bt1);

        sb = findViewById(R.id.seekBar);

        sb.setOnSeekBarChangeListener(this);



    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
        playStop(null);
    }

    boolean is_playing = false;
    public void playStop(View v){
        mp.start();
        if (is_playing) {
            mp.pause();
            is_playing = false;
        }
        else {
            mp.start();
            is_playing = true;
        }
        // меняем изображение на кнопке
        if (flag)
            imageButton.setImageResource(R.drawable.pause);
        else
            // возвращаем первую картинку
            imageButton.setImageResource(R.drawable.play);
        flag = !flag;
    }

    public void Reset(View v){
        mp.seekTo(0);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}