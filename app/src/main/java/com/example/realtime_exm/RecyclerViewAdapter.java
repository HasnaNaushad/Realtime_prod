package com.example.realtime_exm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {
    Context context;
    ArrayList<Modal> datamodallist;

    public RecyclerViewAdapter(Context context, ArrayList<Modal> datamodallist) {
        this.context = context;
        this.datamodallist = datamodallist;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.Viewholder holder, int position) {
        Modal modal = datamodallist.get(position);

        holder.p_name.setText(modal.getName());
        holder.p_price.setText(modal.getPrice());
        holder.p_description.setText(modal.getDescription());

    }

    @Override
    public int getItemCount() {
        return datamodallist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView p_name;
        private TextView p_price;
        private TextView p_description;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            p_name = itemView.findViewById(R.id.name_txt);
            p_price = itemView.findViewById(R.id.price_txt);
            p_description = itemView.findViewById(R.id.desc_txt);

        }
    }
}
