package com.example.myapi;

import com.google.gson.annotations.SerializedName;

public class Post {
    private float id;
    @SerializedName("country")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("code")
    private String country_code;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry_code() {
        return country_code;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
