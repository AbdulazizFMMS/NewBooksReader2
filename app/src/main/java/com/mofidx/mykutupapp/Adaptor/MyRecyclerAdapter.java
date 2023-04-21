package com.mofidx.mykutupapp.Adaptor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mofidx.mykutupapp.R;
import com.mofidx.mykutupapp.listitem;

import java.util.ArrayList;

public class MyRecyclerAdapter  extends RecyclerView.Adapter<MyHolder> {
    ArrayList<listitem> items;

    public MyRecyclerAdapter(ArrayList<listitem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itme,parent , false);
        MyHolder viewholder = new MyHolder(v);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        listitem items1 = items.get(position);
        holder.img1.setImageResource(items1.getImg());
        holder.txt1.setText(items1.getTitle());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}



