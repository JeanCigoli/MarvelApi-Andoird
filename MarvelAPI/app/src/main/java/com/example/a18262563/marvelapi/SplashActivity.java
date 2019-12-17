package com.example.a18262563.marvelapi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    ImageView imgLogo, imgLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgLogo = findViewById(R.id.imgLogo);
        imgLoad = findViewById(R.id.imgLoad);

        Glide.with(this)
                .load("https://media.giphy.com/media/dC3uDJazzlM4z3lZJ5/giphy.gif")
                .into(imgLogo);

        Glide.with(this)
                .load("https://media.giphy.com/media/UtWB4kipDcZvWluE6a/giphy.gif")
                .into(imgLoad);

        // Criação de efeito de carregamento do app
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getBaseContext(), InstrucaoActivity.class);
                startActivity(intent);

                finish();

            }
        },5000);

    }
}
