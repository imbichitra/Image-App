package com.example.imageapp.Network;

import android.util.Log;

import com.example.imageapp.models.ResponseModel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RetrofitRepository {

    private static final String TAG = "RetrofitRepository";
    private String KEY = "20928020-d15494c477a2634c7ffd9b9d4";

    public static RetrofitRepository repository;

    public static RetrofitRepository getInstance() {
        if (repository == null) {
            repository = new RetrofitRepository();
        }
        return repository;
    }

    private ApiRequest apiRequest;
    private Retrofit retrofitClient;

    public RetrofitRepository() {
        apiRequest = RetrofitRequest.createService(ApiRequest.class);
        retrofitClient = RetrofitRequest.getRetrofitClient();
    }

    public Observable<ResponseModel> getPosts() {
        return apiRequest.getPosts(KEY)
                .doOnNext(posts -> {
                    Log.d("tag_", "doOnNext: url = ");
                })
                .doOnError(e -> {
                    Log.d(TAG, "getPosts: error" + e.getMessage());
                })
                .subscribeOn(Schedulers.io());

    }


}
