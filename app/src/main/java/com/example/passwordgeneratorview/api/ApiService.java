package com.example.passwordgeneratorview.api;

import retrofit2.http.Body;
import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiService {
        @POST("api/v1/passwords")
        Call<Void> createPassword(@Body PasswordRequest passwordRequest);

}
