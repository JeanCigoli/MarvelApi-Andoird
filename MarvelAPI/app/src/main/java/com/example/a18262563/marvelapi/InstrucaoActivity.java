package com.example.a18262563.marvelapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class InstrucaoActivity extends AppCompatActivity {

    ImageView imgIntro;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucao);

        imgIntro = findViewById(R.id.imgIntro);
        btnEntrar = findViewById(R.id.btnEntrar);

        Glide.with(this)
                .load("https://media.giphy.com/media/kDwMzy7iCHqLhvNj5D/giphy.gif")
                .into(imgIntro);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
