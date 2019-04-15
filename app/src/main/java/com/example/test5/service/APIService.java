package com.example.test5.service;

import com.example.test5.model.Contact;
import com.example.test5.model.ContactsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface APIService {

    @POST("contacts")
    Call<ContactsList> getList();
}
