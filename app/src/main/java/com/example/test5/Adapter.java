package com.example.test5;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.test5.model.Contact;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Contact> contacts;
    Context context;

    public Adapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Contact model = contacts.get(position);
        holder.txtName.setText(model.getName());
        holder.txtGmail.setText(model.getEmail());
        holder.txtPhone.setText(model.phone.getMobile());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtGmail,txtPhone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.txtRowName);
            txtGmail=itemView.findViewById(R.id.txtRowemail);
            txtPhone=itemView.findViewById(R.id.txtRowphone);


        }
    }
}
