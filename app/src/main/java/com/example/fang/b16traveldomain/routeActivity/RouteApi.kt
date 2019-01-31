package com.example.fang.b16traveldomain.routeActivity

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface RouteApi {
    @POST("routeinfo.php?")
    fun getRoute(@Query("route-startpoint-latitude") route_startpoint_latitude: String,
                 @Query("route-startpoint-longitude") route_startpoint_longitude: String,
                 @Query("route-endpoint-latitude") route_endpoint_latitude: String,
                 @Query("route-endpoint-longiude") route_endpoint_longiude: String): Call<RouteList>


}
