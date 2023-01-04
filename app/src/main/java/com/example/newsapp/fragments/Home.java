package com.example.newsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.ApiUtilities;
import com.example.newsapp.CustomAdapter;
import com.example.newsapp.MainNews;
import com.example.newsapp.ModelClass;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    String api_key="f742764295e44d6dbf81467fc00cf660";
    ArrayList<ModelClass>modelClassArrayList;
    CustomAdapter customAdapter;
    String country="in";
    private RecyclerView recyclerViewHome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,null);
        recyclerViewHome=view.findViewById(R.id.home_recycler);
        modelClassArrayList=new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        customAdapter=new CustomAdapter(getContext(),modelClassArrayList);
        recyclerViewHome.setAdapter(customAdapter);
        findNews();
        return view;
    }
    private void findNews(){
        ApiUtilities.getApiInterface().getNews(country,100,api_key).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    customAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
