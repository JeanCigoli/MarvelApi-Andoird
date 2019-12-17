package com.example.a18262563.marvelapi.model;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a18262563.marvelapi.DetalhesActivity;
import com.example.a18262563.marvelapi.R;
import com.example.a18262563.marvelapi.model.entity.Personagem;

import java.util.List;

public class AdapterPersonagem extends RecyclerView.Adapter<AdapterPersonagem.PersonagemViewHolder>{

    Context context;
    List<Personagem.Data.Results> personagens;

    public AdapterPersonagem(Context context, List<Personagem.Data.Results> personagens) {
        this.context = context;
        this.personagens = personagens;
    }

    @NonNull
    @Override
    public PersonagemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_marvel, null);

        PersonagemViewHolder personagemViewHolder = new PersonagemViewHolder(view);

        return personagemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonagemViewHolder personagemViewHolder, int i) {

        final Personagem.Data.Results personagem = personagens.get(i);

        personagemViewHolder.descPersonagem.setText(personagem.description);
        personagemViewHolder.nomePersonagem.setText(personagem.name);

        Glide.with(context)
                .load(personagem.thumbnail.toString())
                .into(personagemViewHolder.imgPersonagem);

        personagemViewHolder.btnVerMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ver depois
                Bundle bundle = new Bundle();

                bundle.putSerializable("personagem", personagem);

                Intent intent = new Intent(context, DetalhesActivity.class);

                intent.putExtra("object", bundle);

                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return personagens == null ? 0 : personagens.size();
    }

    public class PersonagemViewHolder extends RecyclerView.ViewHolder{

        TextView nomePersonagem, descPersonagem;
        ImageView imgPersonagem;
        Button btnVerMais;

        public PersonagemViewHolder(@NonNull View itemView) {
            super(itemView);

            nomePersonagem = itemView.findViewById(R.id.nomePersonagem);
            descPersonagem = itemView.findViewById(R.id.descPersonagem);
            imgPersonagem = itemView.findViewById(R.id.imgPersonagem);
            btnVerMais = itemView.findViewById(R.id.btnVerMais);

        }
    }

}
