package com.mofidx.mykutupapp.Adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mofidx.mykutupapp.R;


public class MyHolder extends RecyclerView.ViewHolder {
TextView txt1;
ImageView img1;
CardView cardView;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        img1 = itemView.findViewById(R.id.imageViewItem);
        txt1 = itemView.findViewById(R.id.textView_title);
        cardView = itemView.findViewById(R.id.cardclicked);

    }
}
