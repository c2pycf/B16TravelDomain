package com.example.fang.b16traveldomain.bussearch;

import android.util.Log;

import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;
import com.example.fang.b16traveldomain.network.GetDataService;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BusSearchPresenter implements BusSearchContract.BusSearchPresenter {

    private BusSearchContract.BusSearchView busSearchView;
    private Retrofit retrofit;
    private BusInformation busInformation;
    private GetDataService getDataService;
    private static final String TAG = BusSearchPresenter.class.getSimpleName();

    public BusSearchPresenter(BusSearchActivity activity) {
        this.busSearchView = activity;
        retrofit = RetrofitClientInstance.getInstance();
        getDataService = retrofit.create(GetDataService.class);
    }

    @Override
    public void searchBus(String routeId) {
        Call<BusInformationResponse> call = getDataService.getBuses(routeId);
        call.enqueue(new Callback<BusInformationResponse>() {
            @Override
            public void onResponse(Call<BusInformationResponse> call, Response<BusInformationResponse> response) {
                if(response.body() != null){
                    String body = response.message();
                    BusInformationResponse busInformationResponse = response.body();
                    BusInformationResponse busInformation = response.body();
                    Log.e(TAG, "onResponse: " + busInformation.getBusInformationList().get(0).getBusId());
                    busSearchView.showBusSearchActivity(busInformationResponse);
                }
                else {
                    Log.e(TAG, "onResponse: NUll " );
                }
            }

            @Override
            public void onFailure(Call<BusInformationResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
            }
        });
    }

}