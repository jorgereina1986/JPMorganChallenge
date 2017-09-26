package com.jorgereina.jpmorganchallenge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jorgereina.jpmorganchallenge.Models.Response;
import com.jorgereina.jpmorganchallenge.Models.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsFragment extends Fragment {

    private static final String BASE_URL = "http://itunes.apple.com/";

    @BindView(R.id.results_rv) RecyclerView resultsRv;

    private ItunesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Retrofit retrofit;
    private List<Track> trackList;
    String query;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_results_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        trackList = new ArrayList<>();
        adapter = new ItunesAdapter(trackList, getContext());
        layoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        resultsRv.setLayoutManager(layoutManager);
        resultsRv.setAdapter(adapter);
        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        ItunesApi itunesApi = retrofit.create(ItunesApi.class);
        itunesApi.showResults("shakira").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                trackList.addAll(response.body().trackList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }

    protected void setQueryParam(String queryParam) {



    }

}
