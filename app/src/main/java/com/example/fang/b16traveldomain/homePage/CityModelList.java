package com.example.fang.b16traveldomain.homePage;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityModelList {
    @SerializedName("city")
    List<CityModel> cityModelList;

    public CityModelList(List<CityModel> cityModelList) {
        this.cityModelList = cityModelList;
    }

    public List<CityModel> getCityModelList() {
        return cityModelList;
    }

    public void setCityModelList(List<CityModel> cityModelList) {
        this.cityModelList = cityModelList;
    }
}
