package com.jorgereina.jpmorganchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private com.jorgereina.jpmorganchallenge.models.Coord coord;
    @SerializedName("country")
    @Expose
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.jorgereina.jpmorganchallenge.models.Coord getCoord() {
        return coord;
    }

    public void setCoord(com.jorgereina.jpmorganchallenge.models.Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
