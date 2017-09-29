package com.jorgereina.jpmorganchallenge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("list")
    @Expose
    public List<Entry> entryList;

    @SerializedName("resultCount")
    @Expose
    public int resultCount;

}
