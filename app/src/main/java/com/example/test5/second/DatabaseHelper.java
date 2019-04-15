package com.example.test5.second;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.test5.App;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper {

    private SQLiteDatabase mydb;

    public DatabaseHelper(Context context) {
        mydb = new MyDatabase(context).getWritableDatabase();
    }



    // Add list from server into database
    public void addNewEmployee() {
        for (int i = 0; i < App.listContacts.size(); i++) {
            ContentValues values = new ContentValues();

            values.put("name", App.listContacts.get(i).getName());
            values.put("email", App.listContacts.get(i).getEmail());
            values.put("phone", App.listContacts.get(i).phone.getMobile());

            // insert row
            mydb.insert(MyDatabase.tableEmployees, null, values);
        }
        if (mydb != null) {
            mydb.close();
        }
    }



    public List<Employee> getListOfEmployees() {
        Cursor c = mydb.rawQuery("select * from " + MyDatabase.tableEmployees, null);
        List<Employee> employees = new ArrayList<>();

        while (c.moveToNext()) {

            Employee em = new Employee();
            em.setId(c.getInt(c.getColumnIndex(MyDatabase.ID)));
            em.setName(c.getString(c.getColumnIndex(MyDatabase.NAME)));
            em.setEmail(c.getString(c.getColumnIndex(MyDatabase.EMAIL)));
            em.setPhone(c.getString(c.getColumnIndex(MyDatabase.PHONE)));

            employees.add(em);
        }
            c.close();
            mydb.close();
            return employees;
        }
}
