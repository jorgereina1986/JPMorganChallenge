package com.jorgereina.jpmorganchallenge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jorgereina.jpmorganchallenge.Models.Entry;
import com.jorgereina.jpmorganchallenge.Models.WeatherResponse;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {

    private static final String API_KEY = "a503e7a1907bfec5d7baa9fe94018764";
    private static final String BASE_URL = "http://api.openweather.org/";

    @BindView(R.id.search_button) Button searchButton;
    @BindView(R.id.search_input) PlacesAutocompleteTextView searchInput;
    @BindView(R.id.results_rv) RecyclerView resultsRv;

    private RecyclerView.LayoutManager layoutManager;
    private WeatherAdapter adapter;
    private List<Entry> entryList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        entryList = new ArrayList<>();


        entryList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        weatherApi.showResults("Brooklyn", "imperial", API_KEY).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
                layoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                resultsRv.setLayoutManager(layoutManager);
                resultsRv.setAdapter(adapter);
                adapter = new WeatherAdapter(entryList, getContext());
                entryList.addAll(response.body().entryList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = searchInput.getText().toString();

//                entryList = new ArrayList<>();
//                Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//                WeatherApi weatherApi = retrofit.create(WeatherApi.class);
//                weatherApi.showResults("Brooklyn", "imperial").enqueue(new Callback<WeatherResponse>() {
//                    @Override
//                    public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
//                        layoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//                        resultsRv.setLayoutManager(layoutManager);
//                        resultsRv.setAdapter(adapter);
//                        adapter = new WeatherAdapter(entryList, getContext());
//                        entryList.addAll(response.body().entryList);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
//
//                    }
//                });

            }
        });


    }


}
