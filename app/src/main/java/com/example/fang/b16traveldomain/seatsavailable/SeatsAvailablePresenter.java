package com.example.fang.b16traveldomain.seatsavailable;

import android.util.Log;

import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;
import com.example.fang.b16traveldomain.network.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SeatsAvailablePresenter implements SeatsAvailableContract.SeatsAvailablePresenter {

    private SeatsAvailableContract.SeatsAvailableView seatsAvailableView;
    private Retrofit retrofit;
    private Seats seats;
    private GetDataService getDataService;
    private static final String TAG =  SeatsAvailablePresenter.class.getSimpleName();


    @Override
    public void findSeats(String busId) {
        busId = "103";
        Call<Seats> call = getDataService.getSeats(busId);
        call.enqueue(new Callback<Seats>() {
            @Override
            public void onResponse(Call<Seats> call, Response<Seats> response) {
                //Log.e(TAG, "onResponse: ", );
            }

            @Override
            public void onFailure(Call<Seats> call, Throwable t) {

            }
        });
    }
}
