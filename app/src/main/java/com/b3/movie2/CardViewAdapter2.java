package com.b3.movie2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardViewAdapter2 extends RecyclerView.Adapter<CardViewAdapter2.CardViewViewHolder> {
    private ArrayList<TvShow> listTvShow;

    public CardViewAdapter2(ArrayList<TvShow> list){
        this.listTvShow = list;
    }

    public ArrayList<TvShow> getListTvShow(){
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShow> listTvShow){
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public CardViewAdapter2.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewAdapter2.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewAdapter2.CardViewViewHolder holder, int position) {
        final TvShow tvshow = listTvShow.get(position);

        holder.imgPhoto.setImageResource(tvshow.getPhoto());
        holder.Name.setText(tvshow.getName());
        holder.Desc.setText(tvshow.getDesc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailTvShow.class);

                intent.putExtra("photo", tvshow.getPhoto());
                intent.putExtra("name", tvshow.getName());
                intent.putExtra("desc", tvshow.getDesc());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView Name, Desc;
        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            Name = itemView.findViewById(R.id.tv_item_name);
            Desc = itemView.findViewById(R.id.tv_item_desc);
        }
    }
}