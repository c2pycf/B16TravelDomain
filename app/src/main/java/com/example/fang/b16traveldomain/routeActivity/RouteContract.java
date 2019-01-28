package com.example.fang.b16traveldomain.routeActivity;

import java.util.List;

public interface RouteContract {

    interface  RouteView{
        void set_route(List<RouteModel> routeModelList);

    }

    interface Route{
        void get_route();
        void set_lattitude_longitude(String start_Lattitude,String  start_Longitude,String  destination_Lattitude, String destination_Longitude);

    }

}
