package com.example.myapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    ArrayList<Post> posts;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://nurseme.in/NurseMe/api/").addConverterFactory(GsonConverterFactory.create()).build();

        posts = new ArrayList<>();
        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<JsonElement> call = jsonPlaceholder.getCountries();
        call.enqueue(new Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.e("statuscode", String.valueOf(response.code()));
                Log.e("responcebody", String.valueOf(response.body()));
                String searchResponse = response.body().toString();
                System.out.println("responce model search : "+searchResponse);
                try {
                    JSONObject jsonObject = new JSONObject(searchResponse);
                    JSONArray jsonArray = jsonObject.getJSONArray("countries");
                    for (int i = 0; i< ((JSONArray) jsonArray).length(); i++){
                        JSONObject contriesObj = jsonArray.getJSONObject(i);
                        String name = contriesObj.getString("name");
                        String region = contriesObj.getString("region");
                        String country_code = contriesObj.getString("country_code");
                        posts.add(new Post(name,region,country_code));
                    }
                    adapter = new Adapter(posts,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }catch (JSONException e){

                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}