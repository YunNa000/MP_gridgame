package com.example.fpicture;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;


public class CommonActivity extends AppCompatActivity {

    protected MediaPlayer bgmPlayer;
    protected MediaPlayer correctSoundPlayer;
    protected MediaPlayer failSoundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the media players
        bgmPlayer = MediaPlayer.create(this, R.raw.bgm);  // Replace R.raw.bgm with your BGM resource
        correctSoundPlayer = MediaPlayer.create(this, R.raw.correct);  // Replace R.raw.correct_sound with your correct sound resource
        failSoundPlayer = MediaPlayer.create(this, R.raw.fail);  // Replace R.raw.fail_sound with your fail sound resource

        // Start playing BGM
        bgmPlayer.setLooping(true);
        bgmPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release media players
        if (bgmPlayer != null) {
            bgmPlayer.release();
        }
        if (correctSoundPlayer != null) {
            correctSoundPlayer.release();
        }
        if (failSoundPlayer != null) {
            failSoundPlayer.release();
        }
    }

    // Play the correct sound
    protected void playCorrectSound() {
        if (correctSoundPlayer != null) {
            correctSoundPlayer.start();
        }
    }

    // Play the fail sound
    protected void playFailSound() {
        if (failSoundPlayer != null) {
            failSoundPlayer.start();
        }
    }
}