package com.example.fang.b16traveldomain.routeActivity

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class RouteModel(@field:SerializedName("id")
                 var id: String, @field:SerializedName("routename;")
                 var routename: String, @field:SerializedName("route-startfrom")
                 var route_startfrom: String, @field:SerializedName("route-destination")
                 var route_destination: String,
                 @field:SerializedName("route-startpoint-latitude")
                 var route_startpoint_latitude: String, @field:SerializedName("route-startpoint-longitude")
                 var route_startpoint_longitude: String, @field:SerializedName("route-endpoint-latitude")
                 var route_endpoint_latitude: String,
                 @field:SerializedName("route-endpoint-longitude")
                 var route_endpoint_longiude: String) : Serializable
