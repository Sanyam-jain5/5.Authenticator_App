package com.example.authenticatorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Image> images;

    public Adapter(Context ctx, List<Image> images) {
        this.inflater = LayoutInflater.from(ctx);
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        Adapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageTitle.setText(images.get(position).getTitle());
        holder.imageI_D.setText(images.get(position).getI_d());
        holder.imageAlbumI_D.setText(images.get(position).getAlbumId());
        Picasso.get().load(images.get(position).getImageURL()).into(holder.imageBig);
        Picasso.get().load(images.get(position).getThumbnailUrl()).into(holder.imageSmall);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView imageTitle, imageI_D, imageAlbumI_D;
        ImageView imageBig, imageSmall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTitle = itemView.findViewById(R.id.mv_title);
            imageI_D = itemView.findViewById(R.id.id);
            imageAlbumI_D = itemView.findViewById(R.id.album_id);
            imageBig = itemView.findViewById(R.id.mv_image2);
            imageSmall = itemView.findViewById(R.id.mv_image);

        }
    }
}
