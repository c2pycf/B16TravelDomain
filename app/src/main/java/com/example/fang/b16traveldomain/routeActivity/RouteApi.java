package com.example.fang.b16traveldomain.routeActivity;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RouteApi {
    @POST("routeinfo.php?")
    Call<RouteList> getRoute(@Query("route-startpoint-latitude") String route_startpoint_latitude ,
                             @Query("route-startpoint-longitude") String route_startpoint_longitude,
                             @Query("route-endpoint-latitude") String  route_endpoint_latitude,
                             @Query("route-endpoint-longiude") String route_endpoint_longiude);





}
