package com.jorgereina.jpmorganchallenge;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jorgereina.jpmorganchallenge.Models.Entry;
import com.jorgereina.jpmorganchallenge.Models.WeatherResponse;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class SearchFragment extends Fragment {

    private static final String API_KEY = "a503e7a1907bfec5d7baa9fe94018764";
    private static final String BASE_URL = "http://api.openweather.org/";

    @BindView(R.id.search_button)
    ImageButton searchButton;
    @BindView(R.id.search_input)
    PlacesAutocompleteTextView searchInput;
    @BindView(R.id.results_rv)
    RecyclerView resultsRv;

    private RecyclerView.LayoutManager layoutManager;
    private WeatherAdapter adapter;
    private List<Entry> entryList;
    private Handler handler;
    private OkHttpClient okHttpClient;
    private Request request;


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
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        resultsRv.setLayoutManager(layoutManager);
        adapter = new WeatherAdapter(entryList, getContext());
        resultsRv.setAdapter(adapter);
        handler = new Handler(Looper.getMainLooper());
        okHttpClient = new OkHttpClient();

        request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?q=London,us&units=imperial&appid=a503e7a1907bfec5d7baa9fe94018764")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "Unable to retrieve data", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                String json = response.body().string();

                Gson gson = new Gson();
                final WeatherResponse weatherResponse = gson.fromJson(json, WeatherResponse.class);

                Log.d(TAG, "onWResponse: " + weatherResponse.getEntry().get(0).getMain().getTemp());
                entryList.addAll(weatherResponse.getEntry());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });


            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
