package com.example.passwordgeneratorview.api;

import retrofit2.http.Body;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

        @GET("api/v1/passwords")
        Call<String> getYourData();

        @POST("api/v1/passwords")
        Call<String> createPassword(@Body PasswordRequest passwordRequest);

        @POST("api/v1/passwords")
        Call<String> createPassword(@Body SoundLikePasswordRequest soundLikePasswordRequest);

}
