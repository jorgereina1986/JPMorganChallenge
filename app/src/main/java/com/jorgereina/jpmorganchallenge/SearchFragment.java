package com.jorgereina.jpmorganchallenge;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private List<com.jorgereina.jpmorganchallenge.Models.List> entryList;
    private Handler handler;

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


//        entryList = new ArrayList<>();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
//        weatherApi.showResults("Brooklyn", "imperial", API_KEY).enqueue(new Callback<WeatherResponse>() {
//            @Override
//            public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
//                Log.d(TAG, "onResponse: "+response.code());
//                layoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//                resultsRv.setLayoutManager(layoutManager);
//                resultsRv.setAdapter(adapter);
//                adapter = new WeatherAdapter(entryList, getContext());
//                entryList.addAll(response.body().entryList);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<WeatherResponse> call, Throwable t) {
//
//            }
//        });


        handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        OkHttpClient okHttpClient = new OkHttpClient();


        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?q=London,us&units=imperial&appid=a503e7a1907bfec5d7baa9fe94018764")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), e + "", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                Log.d(TAG, "onResponse: " + response.body().string());


            }
        });


//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                OkHttpClient.Builder client = new OkHttpClient.Builder();
//
//                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                client.addInterceptor(loggingInterceptor);
//
//                String input = searchInput.getText().toString();
////                Gson gson = new Gson();
////                JsonReader reader = new JsonReader(new StringReader());
////                reader.setLenient(true);
//
//                Gson gson = new GsonBuilder().setLenient().create();
//
//
//                entryList = new ArrayList<>();
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .client(client.build())
//                        .addConverterFactory(LenientGsonConverterFactory.create())
//                        .build();
//
//                WeatherApi weatherApi = retrofit.create(WeatherApi.class);
////                weatherApi.showResults("brooklyn", "imperial", API_KEY).enqueue(new Callback<WeatherResponse>() {
//                weatherApi.showResults().enqueue(new Callback<WeatherResponse>() {
//
//                    @Override
//                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
//
//                        Log.d(TAG, "onResponse: " + response.isSuccessful());
//                        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//                        resultsRv.setLayoutManager(layoutManager);
//                        resultsRv.setAdapter(adapter);
//                        adapter = new WeatherAdapter(entryList, getContext());
////                        entryList.addAll(response.body().getList());
//
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherResponse> call, Throwable throwable) {
//                        Toast.makeText(getContext(), throwable + "", Toast.LENGTH_LONG).show();
//                    }
//                });
//
//            }
//        });


    }


}
