package com.example.fang.b16traveldomain.routeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.bussearch.BusSearchActivity;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.List;

public class RouteActivity extends AppCompatActivity implements RouteContract.RouteView  {
    RouteContract.RouteView routeView;

    RoutePresenter routePresenter;

    RetrofitClientInstance retrofitClientInstance;
    TextView tv_start_city, tv_destination_city;

    Button button;

    //String routeId;



    String id,  routename, route_startfrom,  route_destination, route_startpoint_latitude, route_startpoint_longitude,  route_endpoint_latitude,
            route_endpoint_longiude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        Intent intent = getIntent();

        route_startpoint_latitude = intent.getStringExtra("route_startpoint_latitude");
        route_startpoint_longitude = intent.getStringExtra("route_startpoint_longitude");

        route_endpoint_latitude = intent.getStringExtra("route_endpoint_latitude");
        route_endpoint_longiude = intent.getStringExtra("route_endpoint_longiude");


        id = intent.getStringExtra("id");

        routename = intent.getStringExtra("routename");
        route_startfrom = intent.getStringExtra("route_startfrom");
        route_destination = intent.getStringExtra("route_destination");

        tv_start_city = findViewById(R.id.tv_start_city);
        tv_destination_city = findViewById(R.id.tv_destination);

        button = findViewById(R.id.btn_bussearch);

        tv_start_city.setText(route_startfrom);
        tv_destination_city.setText(route_destination);






//        routePresenter = new RoutePresenter(this );
//
//        routePresenter.set_lattitude_longitude(route_startpoint_latitude, route_startpoint_longitude, destination_lattitude, destination_longitude);

        //routePresenter.get_route();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RouteActivity.this, BusSearchActivity.class);
                intent.putExtra("routeId", id);

                startActivity(intent);
            }
        });










    }

    @Override
    public void set_route(List<RouteModel> routeModelList) {

//        tv_destination_city.setText(routeModelList.get(0).getRoute_destination());
//        tv_start_city.setText(routeModelList.get(0).getRoute_startfrom());

        //routeId = routeModelList.get(0).getId();



    }
}
