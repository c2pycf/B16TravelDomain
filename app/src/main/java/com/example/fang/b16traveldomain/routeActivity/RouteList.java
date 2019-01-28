package com.example.fang.b16traveldomain.routeActivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteList {

    @SerializedName("route")
    List<RouteModel> routeModelList;

    public RouteList(List<RouteModel> routeModelList) {
        this.routeModelList = routeModelList;
    }

    public List<RouteModel> getRouteModelList() {
        return routeModelList;
    }

    public void setRouteModelList(List<RouteModel> routeModelList) {
        this.routeModelList = routeModelList;
    }


}
