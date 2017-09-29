package com.jorgereina.jpmorganchallenge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {

    @SerializedName("main")
    @Expose
    public Main main;

    @SerializedName("weather")
    @Expose
    public List<Weather> weather;

    public Wind wind;

}
