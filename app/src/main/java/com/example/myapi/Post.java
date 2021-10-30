package com.example.myapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Post {
//    private float id;
@SerializedName("country")
private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("code")
    private String country_code;
    @SerializedName("countries")
    private List<Post> countries = new ArrayList<>();

    public List<Post> getCountries() {
        return countries;
    }

    public Post(String name, String region, String country_code) {
        this.name = name;
        this.region = region;
        this.country_code = country_code;
    }

    public void setCountries(List<Post> countries) {
        this.countries = countries;
    }

    // Getter Methods

//    public float getId() {
//        return id;
//    }

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

//    public void setId(float id) {
//        this.id = id;
//    }

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
