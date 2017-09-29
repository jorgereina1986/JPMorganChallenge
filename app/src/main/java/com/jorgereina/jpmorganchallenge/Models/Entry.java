package com.jorgereina.jpmorganchallenge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("main")
    @Expose
    public Main main;

    @SerializedName("weather")
    @Expose
    public Weather weather;

    public Wind wind;

}
