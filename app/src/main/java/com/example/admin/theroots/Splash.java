package com.example.admin.theroots;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.admin.theroots.MainActivity;
import com.example.admin.theroots.R;

public class Splash extends AppCompatActivity {
    public int Time_DelayForRequest = 1000;
    public int splashScreentime = 3 * Time_DelayForRequest;
    Thread background;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        int SPLASH_TIME_OUT = 4000;


        background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(splashScreentime);

                    startActivity(new Intent(Splash.this, Main2Activity.class));
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        background.start();
    }
}

