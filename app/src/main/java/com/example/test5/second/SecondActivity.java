package com.example.test5.second;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.test5.Adapter;
import com.example.test5.App;
import com.example.test5.R;
import com.example.test5.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DbAdapter adapter;
    Context context;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        context=this;
        init();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        //call add to (add list from server into database)
      databaseHelper=new DatabaseHelper(this);
      databaseHelper.addNewEmployee();

        List<Employee> employees = new DatabaseHelper(this).getListOfEmployees();
        adapter = new DbAdapter(this, employees);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        recyclerView=findViewById(R.id.rv_second);
    }
}
