package com.example.pit.piotrjedrzejczak;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    private final Handler handler = new Handler();

    private final Runnable r = new Runnable() {
        public void run (){
            Intent intent = new Intent(StartScreen.this, MainScreen.class);
            finish();
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        handler.postDelayed(r, 5000);
    }

    public void goBack(@SuppressWarnings("UnusedParameters") View view) {

          handler.removeCallbacks(r);

//        Jesli program ma nie tylko zatrzymac przejscie do ekranu startowego a takze wyjsc z aplikacji
//        to dodajemy tez ponizszy kod
//        finish();
//        System.exit(0);
    }
}
