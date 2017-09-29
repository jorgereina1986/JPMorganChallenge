package com.jorgereina.jpmorganchallenge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    public int temperature;
    @SerializedName("temp_min")
    @Expose
    public int minTemperature;
    @SerializedName("humidity")
    @Expose
    public int humidity;
}
