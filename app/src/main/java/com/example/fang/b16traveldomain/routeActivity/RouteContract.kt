package com.example.fang.b16traveldomain.routeActivity

interface RouteContract {

    interface RouteView {
        fun set_route(routeModelList: List<RouteModel>)

    }

    interface Route {
        fun get_route()
        fun set_lattitude_longitude(start_Lattitude: String, start_Longitude: String, destination_Lattitude: String, destination_Longitude: String)

    }

}
