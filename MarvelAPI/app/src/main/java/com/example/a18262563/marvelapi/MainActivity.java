package com.example.a18262563.marvelapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar toolbar;
    SearchView searchView;
    ImageView imgView;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.gifHerois);
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.searchView);
        texto = findViewById(R.id.txtMensagem);


        Glide.with(this)
                .load(R.drawable.herois)
                .into(imgView);

        toolbar.setTitle("Marvel API");
        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(this);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Pesquise seu heroi");

    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        String heroi = s;

        Intent intent = new Intent(this, PersonagemActivity.class);

        intent.putExtra("heroi", heroi);
        startActivity(intent);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
