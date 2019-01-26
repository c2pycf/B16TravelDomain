package com.example.fang.b16traveldomain.homePage;

import com.google.gson.annotations.SerializedName;

public class CityModel {
    @SerializedName("cityname")
    String Cityname;
    @SerializedName("citylatitude")
    String lattitude;
    @SerializedName("citylongtitude")
    String longitude;

    public CityModel(String cityname, String lattitude, String longitude) {
        Cityname = cityname;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public String getCityname() {
        return Cityname;
    }

    public void setCityname(String cityname) {
        Cityname = cityname;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
