package com.example.buylap;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    List<Category> category;

    private OnCatListener mOnCatListener;

    public CategoryAdapter(List<Category> category, OnCatListener onCatListener) {

        this.category = category;
        this.mOnCatListener=onCatListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder2, parent, false);
        return new ViewHolder(inflate, mOnCatListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(String.valueOf(category.get(position).getTitle()));

        holder.subTitleTxt.setText(String.valueOf(category.get(position).getSubtitles()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(category.get(position).getUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.imageCat);
    }


    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleTxt;
        TextView subTitleTxt;
        ImageView imageCat;
        OnCatListener onCatListener;
        Context context;
        public ViewHolder(View itemView, OnCatListener onCatListener) {
            super(itemView);
            context= itemView.getContext();
            titleTxt = itemView.findViewById(R.id.titleTxt2);
            subTitleTxt = itemView.findViewById(R.id.titleTxt3);
            imageCat = itemView.findViewById(R.id.img_view);
            this.onCatListener=onCatListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCatListener.onCatClick(getAdapterPosition());
        }
    }
    public interface OnCatListener{
        void onCatClick(int position);
    }
}
