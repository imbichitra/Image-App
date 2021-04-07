package com.example.imageapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imageapp.R;

public class ImageDetailsActivity extends AppCompatActivity {

    Context context;
    ImageView ivImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        context = this;
        ivImage = findViewById(R.id.iv_image);
        String url = getIntent().getStringExtra("url");
        loadImage(url);
    }

    private void loadImage(String url) {
        Glide.with(context)
                .load(url)
                .into(ivImage);
    }
}