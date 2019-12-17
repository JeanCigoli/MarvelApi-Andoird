package com.example.a18262563.marvelapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a18262563.marvelapi.model.entity.Personagem;

import java.io.Serializable;
import java.util.List;

public class DetalhesActivity extends AppCompatActivity {

    ListView listComics;
    Toolbar toolbar;
    TextView descPersonagem, nomePersonagem;

    ArrayAdapter<Personagem.Data.Results.Comics.Items> adapterComics;
    List<Personagem.Data.Results.Comics.Items> comics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        toolbar = findViewById(R.id.toolbar);
        descPersonagem = findViewById(R.id.descPersonagem);
        nomePersonagem = findViewById(R.id.nomePersonagem);
        listComics = findViewById(R.id.listComics);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("object");

        Personagem.Data.Results results = (Personagem.Data.Results) bundle.getSerializable("personagem");

        descPersonagem.setText(results.description);
        nomePersonagem.setText(results.name);

        comics = results.comics.items;

        // Adaptando o lista
        adapterComics = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                comics
        );

        // liga a lista ao adapter
        listComics.setAdapter(adapterComics);


        toolbar.setTitle("Detalhes do Personagem");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
