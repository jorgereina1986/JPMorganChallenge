package com.jorgereina.jpmorganchallenge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    public int speed;
}
