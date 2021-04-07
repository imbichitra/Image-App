package com.example.imageapp.Network;

import com.example.imageapp.models.ResponseModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface  ApiRequest {

    @Headers({"Content-type: application/json; charset=UTF-8" })
    @GET("api/")
    Observable<ResponseModel> getPosts(@Query("key") String key);

}
