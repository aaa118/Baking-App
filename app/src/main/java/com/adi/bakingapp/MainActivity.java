package com.adi.bakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.adi.bakingapp.model.RecipeName;
import com.adi.bakingapp.network.RetroFitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AA_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        networkRequest();
    }

    private void networkRequest() {
        RetroFitInstance.getRetrofitService().getRecipeInfo().enqueue(new Callback<List<RecipeName>>() {
            @Override
            public void onResponse(Call<List<RecipeName>> call, Response<List<RecipeName>> response) {
                Log.i(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<List<RecipeName>> call, Throwable t) {

            }
        });
    }
}
