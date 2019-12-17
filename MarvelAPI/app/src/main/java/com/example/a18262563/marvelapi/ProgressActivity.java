package com.example.a18262563.marvelapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProgressActivity extends AppCompatActivity {

    ImageView imgLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        imgLoad = findViewById(R.id.imgLoad);

        Glide.with(this)
                .load("https://media.giphy.com/media/UtWB4kipDcZvWluE6a/giphy.gif")
                .into(imgLoad);
    }
}
