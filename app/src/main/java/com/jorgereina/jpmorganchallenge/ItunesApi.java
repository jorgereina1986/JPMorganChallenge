package com.jorgereina.jpmorganchallenge;

import com.jorgereina.jpmorganchallenge.Models.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesApi {

    //http://itunes.apple.com/search?term=shakira
    @GET("search?")
    Call<Response> showResults(@Query("term") String input);
}
