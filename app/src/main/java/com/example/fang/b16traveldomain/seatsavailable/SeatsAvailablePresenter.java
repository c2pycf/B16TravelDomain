package com.example.fang.b16traveldomain.seatsavailable;

import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;
import com.example.fang.b16traveldomain.network.GetDataService;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SeatsAvailablePresenter implements SeatsAvailableContract.SeatsAvailablePresenter {

    private SeatsAvailableContract.SeatsAvailableView view;
    private Retrofit retrofit;
    private Seats seats;
    private GetDataService getDataService;
    private static final String TAG =  SeatsAvailablePresenter.class.getSimpleName();

    public SeatsAvailablePresenter(SeatsAvailableActivity activity) {
        this.view = activity;
        retrofit = RetrofitClientInstance.getInstance();
        getDataService = retrofit.create(GetDataService.class);
    }

    @Override
    public void findSeats(String busId) {
        busId = "103";
        Call<Seats> call = getDataService.getSeats(busId);
        call.enqueue(new Callback<Seats>() {
            @Override
            public void onResponse(Call<Seats> call, Response<Seats> response) {
                if(response.body() != null){
                    Seats seats = response.body();
                    Log.e(TAG, "onResponse: " + seats.getSeats().get(0).getTotalSeat());
                } else
                    Log.e(TAG, "onResponse: "+ response.body() );

            }

            @Override
            public void onFailure(Call<Seats> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );

            }
        });
    }
}
