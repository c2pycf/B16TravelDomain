package com.example.fang.b16traveldomain.routeActivity;

public interface RouteContract {

    interface  RouteView{

    }

    interface Route{
        void get_route(String start_lattitude, String start_longitude , String destination_lattitude, String destination_longitude);
    }

}
