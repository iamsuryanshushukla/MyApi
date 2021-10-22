package com.example.myapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://nurseme.in/NurseMe/api/").addConverterFactory(GsonConverterFactory.create()).build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<Post> call = jsonPlaceholder.getCountries();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("statuscode", String.valueOf(response.code()));
                Log.e("responcebody", String.valueOf(response.body()));

                if (response.code() == HttpsURLConnection.HTTP_OK) {
                    List<Post> model = response.body().getCountries();
                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    for (Post post : model) {
                        ArrayList list = new ArrayList();
                        list.add(post);
                        Adapter adapter = new Adapter(list, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}