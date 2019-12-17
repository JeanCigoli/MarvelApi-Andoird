package com.example.a18262563.marvelapi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a18262563.marvelapi.model.AdapterPersonagem;
import com.example.a18262563.marvelapi.model.PersonagemDAO;
import com.example.a18262563.marvelapi.model.entity.Personagem;

import java.util.List;

public class PersonagemActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    static String heroi;

    List<Personagem.Data.Results> result;

    ImageView btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);

        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);

        Intent intent = getIntent();

        heroi = intent.getStringExtra("heroi");

        carregarPersonagens();

        toolbar.setTitle("Heróis");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void carregarPersonagens() {

        PersonagemDAO pDAO = new PersonagemDAO();
        Personagem personagens = pDAO.listarTodos(heroi);

        result = personagens.data.results;

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        AdapterPersonagem adapterPersonagem = new AdapterPersonagem(this, result);
        recyclerView.setAdapter(adapterPersonagem);


        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer position = layoutManager.findFirstCompletelyVisibleItemPosition();

                if (position > 0) {
                    recyclerView.smoothScrollToPosition(position - 1);
                } else {
                    recyclerView.smoothScrollToPosition(0);
                }

            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer position = layoutManager.findLastCompletelyVisibleItemPosition();

                recyclerView.smoothScrollToPosition(position + 1);

            }
        });


    }

}
