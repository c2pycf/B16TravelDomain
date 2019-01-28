package com.example.fang.b16traveldomain.routeActivity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RouteModel implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("routename;")
    String routename;
    @SerializedName("route-startfrom")
    String route_startfrom;
    @SerializedName("route-destination")
    String route_destination;
    @SerializedName("route-startpoint-latitude")
    String route_startpoint_latitude;
    @SerializedName("route-startpoint-longitude")
    String route_startpoint_longitude;
    @SerializedName("route-endpoint-latitude")
    String route_endpoint_latitude;
    @SerializedName("route-endpoint-longitude")
    String route_endpoint_longiude;


    public RouteModel(String id, String routename, String route_startfrom, String route_destination,
                      String route_startpoint_latitude, String route_startpoint_longitude, String route_endpoint_latitude,
                      String route_endpoint_longiude)
    {
        this.id = id;
        this.routename = routename;
        this.route_startfrom = route_startfrom;
        this.route_destination = route_destination;
        this.route_startpoint_latitude = route_startpoint_latitude;
        this.route_startpoint_longitude = route_startpoint_longitude;
        this.route_endpoint_latitude = route_endpoint_latitude;
        this.route_endpoint_longiude = route_endpoint_longiude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getRoute_startfrom() {
        return route_startfrom;
    }

    public void setRoute_startfrom(String route_startfrom) {
        this.route_startfrom = route_startfrom;
    }

    public String getRoute_destination() {
        return route_destination;
    }

    public void setRoute_destination(String route_destination) {
        this.route_destination = route_destination;
    }

    public String getRoute_startpoint_latitude() {
        return route_startpoint_latitude;
    }

    public void setRoute_startpoint_latitude(String route_startpoint_latitude) {
        this.route_startpoint_latitude = route_startpoint_latitude;
    }

    public String getRoute_startpoint_longitude() {
        return route_startpoint_longitude;
    }

    public void setRoute_startpoint_longitude(String route_startpoint_longitude) {
        this.route_startpoint_longitude = route_startpoint_longitude;
    }

    public String getRoute_endpoint_latitude() {
        return route_endpoint_latitude;
    }

    public void setRoute_endpoint_latitude(String route_endpoint_latitude) {
        this.route_endpoint_latitude = route_endpoint_latitude;
    }

    public String getRoute_endpoint_longiude() {
        return route_endpoint_longiude;
    }

    public void setRoute_endpoint_longiude(String route_endpoint_longiude) {
        this.route_endpoint_longiude = route_endpoint_longiude;
    }
}
