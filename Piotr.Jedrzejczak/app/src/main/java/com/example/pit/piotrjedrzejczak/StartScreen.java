package com.example.pit.piotrjedrzejczak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    private final Handler handler = new Handler();
    private boolean saveLogin;

    private final Runnable runnable = new Runnable() {

        public void run() {

            if (!saveLogin) {
                Intent intent = new Intent(StartScreen.this, LoginScreen.class);
                finish();
                startActivity(intent);
            } else {
                Intent intent = new Intent(StartScreen.this, MainScreen.class);
                finish();
                startActivity(intent);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        saveLogin = sharedPref.getBoolean("saveLogin", false);

        handler.postDelayed(runnable, 5000);
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }

    public void goBack(@SuppressWarnings("UnusedParameters") View view) {

        handler.removeCallbacks(runnable);
    }
}
