package com.example.fang.b16traveldomain.routeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fang.b16traveldomain.R;

public class RouteActivity extends AppCompatActivity  {

    String start_lattitude, start_longitude, destination_lattitude, destination_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        Intent intent = getIntent();

        start_lattitude = intent.getStringExtra("start_lattitude");
        start_longitude = intent.getStringExtra("start_longitude");

        destination_lattitude = intent.getStringExtra("destination_lattitude");
        destination_longitude = intent.getStringExtra("destination_longitude");






    }
}
