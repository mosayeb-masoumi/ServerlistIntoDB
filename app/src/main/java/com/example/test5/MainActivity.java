package com.example.test5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test5.model.Contact;
import com.example.test5.model.ContactsList;
import com.example.test5.second.SecondActivity;
import com.example.test5.service.APIClient;
import com.example.test5.service.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    List<Contact> list = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;

    Button btn;

//    https://www.androidhive.info/2012/01/android-json-parsing-tutorial/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        recyclerView=findViewById(R.id.recyclereview);

        btn=findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, SecondActivity.class));
            }
        });

        sendRequest();
    }

    private void sendRequest() {

        APIService apiService = APIClient.getClient().create(APIService.class);
        Call<ContactsList> call = apiService.getList();
       call.enqueue(new Callback<ContactsList>() {
           @Override
           public void onResponse(Call<ContactsList> call, Response<ContactsList> response) {
               if(response.code()==200){

                   App.listContacts=response.body().contacts;
                   setAdapter();
               }else {
                   Toast.makeText(MainActivity.this, "gggg", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<ContactsList> call, Throwable t) {
               Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

    }

    private void setAdapter() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(App.listContacts,context);
        recyclerView.setAdapter(adapter);
    }
}
