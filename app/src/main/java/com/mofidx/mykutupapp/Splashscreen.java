package com.mofidx.mykutupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Splashscreen extends AppCompatActivity {
TextView textView2;

ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        progressBar2 =findViewById(R.id.progressBar2);
        textView2 =findViewById(R.id.txt2);


        progressBar2.setMax(100);
        progressBar2.setScaleY(2f);

        progressAnimaion();

// This method is used so that your splash activity can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        setContentView(R.layout.activity_main); // this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(i); // invoke the SecondActivity.
                finish(); // the current activity will get finished.
            }
        }, 5000);



    }

    private void progressAnimaion() {
        ProgressBarAnimationForSplashscreen progressBarAnimationForSplashscreen = new ProgressBarAnimationForSplashscreen(progressBar2  ,textView2, 0f,100f);
        progressBarAnimationForSplashscreen.setDuration(500);
        progressBar2.setAnimation(progressBarAnimationForSplashscreen);

    }
}