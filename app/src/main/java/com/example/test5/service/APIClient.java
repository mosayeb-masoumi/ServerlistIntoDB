package com.example.test5.service;

import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder()
//                        .baseUrl(App.ServerURL + "/Passenger/")
                        .baseUrl("https://api.androidhive.info/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception e) {

            }

        }
        return retrofit;
    }
}

