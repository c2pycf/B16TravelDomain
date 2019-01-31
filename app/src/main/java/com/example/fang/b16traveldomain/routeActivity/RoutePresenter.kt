package com.example.fang.b16traveldomain.routeActivity

import android.util.Log
import android.view.View
import android.widget.Toast

import com.example.fang.b16traveldomain.network.RetrofitClientInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RoutePresenter(activity: RouteActivity) : RouteContract.Route {
    lateinit var start_Lattitude: String
    lateinit var start_Longitude: String
    lateinit var destination_Lattitude: String
    lateinit var destination_Longitude: String

    internal var routeView: RouteContract.RouteView
    internal var retrofit: Retrofit

    internal var TAG = "Route Presenter"

    init {
        this.routeView = activity
        this.retrofit = RetrofitClientInstance.getInstance()
    }

    override fun get_route() {

    }

    override fun set_lattitude_longitude(start_lattitude: String, start_longitude: String,
                                         destination_lattitude: String, destination_longitude: String) {
        this.start_Lattitude = start_lattitude
        this.start_Longitude = start_longitude
        this.destination_Lattitude = destination_lattitude
        this.destination_Longitude = destination_longitude


    }
}
