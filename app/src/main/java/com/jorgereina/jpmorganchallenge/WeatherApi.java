package com.jorgereina.jpmorganchallenge;

import com.jorgereina.jpmorganchallenge.Models.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    //http://itunes.apple.com/search?term=shakira
    @GET("search?")
    Call<WeatherResponse> showResults(@Query("term") String input);
}
