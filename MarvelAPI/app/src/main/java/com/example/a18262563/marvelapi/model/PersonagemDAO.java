package com.example.a18262563.marvelapi.model;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

import com.example.a18262563.marvelapi.ProgressActivity;
import com.example.a18262563.marvelapi.model.entity.AutenticacaoAPI;
import com.example.a18262563.marvelapi.model.entity.Personagem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PersonagemDAO {


    public Personagem listarTodos(String nome){

        String url, publicKey, hash, date, heroi;

        AutenticacaoAPI autenticacaoAPI = new AutenticacaoAPI();
        PersonagensTask personagensTask = new PersonagensTask();

        heroi = nome;
        publicKey = autenticacaoAPI.getPublicKey();
        date = autenticacaoAPI.getDateKey();
        hash = autenticacaoAPI.getMD5Key();

        url = "https://gateway.marvel.com:443/v1/public/characters?nameStartsWith=" + heroi + "&ts=" + date + "&apikey=" + publicKey + "&hash=" + hash;

        Log.i("Url", url);

        personagensTask.execute(url);

        Personagem personagens = null;

        try {

            personagens = personagensTask.get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return personagens;
    }

    class PersonagensTask extends AsyncTask<String, Void, Personagem>{


        @Override
        protected Personagem doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);

                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                conexao.connect();

                InputStream is  = conexao.getInputStream();

                Reader reader = new InputStreamReader(is);

                Type type = new TypeToken<Personagem>(){}.getType();
                Personagem listPersonagem = new Gson().fromJson(reader, type);

                return listPersonagem;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;

        }
    }


}
