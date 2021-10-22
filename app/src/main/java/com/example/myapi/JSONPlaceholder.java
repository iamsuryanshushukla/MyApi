package com.example.myapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {
    @GET("get-countries")
    Call<Post> getCountries();

}
