package com.example.a18262563.marvelapi.model.entity;

import android.provider.MediaStore;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Personagem implements Serializable {

    @SerializedName("data")
    public Data data;

    public Personagem() {
    }

    public class Data implements Serializable{

        @SerializedName("results")
        public List<Results> results;

        public List<Results> getResults() {
            return results;
        }

        public Data() {
        }

        public class Results implements Serializable  {

            public Results() {
            }

            @SerializedName("id")
            public Integer id;

            @SerializedName("name")
            public String name;

            @SerializedName("description")
            public String description;

            @SerializedName("thumbnail")
            public Thumbnail thumbnail;


            public class Thumbnail implements Serializable {

                @SerializedName("path")
                public String path;

                @SerializedName("extension")
                public String extension;

                @Override
                public String toString() {
                    return path + "." + extension;
                }

                public Thumbnail() {
                }
            }

            @SerializedName("comics")
            public Comics comics;

            public class Comics implements Serializable{

                public Comics() {
                }

                @SerializedName("items")
                public List<Items> items;

                public class Items implements Serializable {

                    public Items() {
                    }

                    @SerializedName("name")
                    public String name;

                    @NonNull
                    @Override
                    public String toString() {
                        return name;
                    }
                }
            }

        }


    }

}
