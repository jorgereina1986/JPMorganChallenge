package com.jorgereina.jpmorganchallenge;

import com.jorgereina.jpmorganchallenge.Models.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    //http://api.openweathermap.org/data/2.5/forecast?q=London,us&units=imperial&appid=a503e7a1907bfec5d7baa9fe94018764
    @GET("data/2.5/weather?q=London,us&appid=a503e7a1907bfec5d7baa9fe9401876")
//    Call<WeatherResponse> showResults(@Query("q") String location, @Query("units") String format, @Query("appid") String apiKey);
    Call<WeatherResponse> showResults();
}
