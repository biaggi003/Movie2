package com.b3.movie2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {

    private ArrayList<Movie> listMovie;
    private Context context;
    private static OnItemClickListener Listener;

    public CardViewAdapter(ArrayList<Movie> list){
        this.listMovie = list;
    }

    public CardViewAdapter(Context context) {
        this.context = context;
    }

    public static void setOnItemClickListener(OnItemClickListener listener){
        Listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public ArrayList<Movie> getListMovie(){
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie){
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);

        holder.imgPhoto.setImageResource(movie.getPhoto());
        holder.Name.setText(movie.getName());
        holder.Desc.setText(movie.getDesc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
           public void onClick(View v) {
               Intent intent = new Intent(holder.itemView.getContext(), DetailMovie.class);

               intent.putExtra("photo", movie.getPhoto());
               intent.putExtra("name", movie.getName());
               intent.putExtra("desc", movie.getDesc());

               holder.itemView.getContext().startActivity(intent);
           }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
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
