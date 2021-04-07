package com.example.imageapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.imageapp.R;
import com.example.imageapp.adapters.ImageAdapter;
import com.example.imageapp.models.ResponseModel;
import com.example.imageapp.viewModels.MainActivityViewModel;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Context context;
    MainActivityViewModel viewModel;
    RecyclerView rvImages;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        initRecyclerView();

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.init();

        viewModel.getPosts();

    }

    private void initRecyclerView() {
        rvImages = findViewById(R.id.rv_images);
        rvImages.setLayoutManager(new GridLayoutManager(context,2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        render();
    }

    private void render() {
        viewModel.getArticles().observe(this, this::logData);
    }

    public void logData(ResponseModel models) {
        Log.d("tag_", "logData: " + new Gson().toJson(models));
        adapter = new ImageAdapter(context,models.getHits());
        rvImages.setAdapter(adapter);
    }

    public void imageClickHandler(String url){
        Intent intent = new Intent(this,ImageDetailsActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}