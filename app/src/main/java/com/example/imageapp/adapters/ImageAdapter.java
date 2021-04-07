package com.example.imageapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imageapp.R;
import com.example.imageapp.models.HitsModel;
import com.example.imageapp.views.MainActivity;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    Context context;
    List<HitsModel> dataModel;

    public ImageAdapter(Context context, List<HitsModel> dataModel) {
        this.context = context;
        this.dataModel = dataModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(dataModel.get(position).getPreviewURL())
                .into(holder.ivImage);
        Log.d("tag_iv", "onBindViewHolder: "+ dataModel.get(position).getPreviewURL());

        holder.itemView.setOnClickListener(v -> ((MainActivity)context).imageClickHandler(dataModel.get(position).getLargeImageURL()));
    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }

}
