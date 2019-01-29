package com.example.fang.b16traveldomain.routeActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RoutePresenter implements RouteContract.Route {
    String start_Lattitude, start_Longitude, destination_Lattitude, destination_Longitude;

    RouteContract.RouteView routeView;
    Retrofit retrofit;

    String TAG = "Route Presenter";

    public RoutePresenter(RouteActivity activity) {
        this.routeView = activity;
        this.retrofit = RetrofitClientInstance.getInstance();
    }

    @Override
    public void get_route() {

    }

    @Override
    public void set_lattitude_longitude(String start_lattitude,String  start_longitude,
                                        String destination_lattitude , String  destination_longitude) {
        start_Lattitude = start_lattitude;
        start_Longitude = start_longitude;
        destination_Lattitude= destination_lattitude;
        destination_Longitude = destination_longitude;




    }
}
