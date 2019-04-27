package com.example.android.kalpanaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                    Intent intent = new Intent(getApplicationContext(), Language.class);
                    Bundle b = new Bundle();
                    b.putString("Activity", "Splash");
                    intent.putExtras(b);
                    startActivity(intent);

                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        myThread.start();
    }
}
