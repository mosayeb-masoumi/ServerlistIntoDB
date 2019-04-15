package com.example.test5.second;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test5.R;

import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {

    Context context;
    List<Employee> employeeList;


    public DbAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public DbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_second,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DbAdapter.ViewHolder holder, int position) {

        Employee model=employeeList.get(position);
        holder.txtDbName.setText(model.getName());
        holder.txtDbEmail.setText(model.getEmail());
        holder.txtDbPhone.setText(model.getPhone());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDbName,txtDbEmail,txtDbPhone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDbName=itemView.findViewById(R.id.txtDbName);
            txtDbEmail=itemView.findViewById(R.id.txtDbemail);
            txtDbPhone=itemView.findViewById(R.id.txtDbphone);
        }
    }
}
