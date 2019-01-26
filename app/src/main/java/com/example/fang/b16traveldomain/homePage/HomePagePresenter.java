package com.example.fang.b16traveldomain.homePage;

import android.util.Log;

import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.support.constraint.Constraints.TAG;

public class HomePagePresenter implements  HomePageContract.HomeFragmentPresenter {

    HomePageContract.HomeFragmentView homeFragmentView ;

    Retrofit retrofitClientInstance;
    // = RetrofitClientInstance.getInstance();

    CityModelList cityModelList;






    public HomePagePresenter(HomePageFragment fragment) {
        this.homeFragmentView = fragment;
        this.retrofitClientInstance = RetrofitClientInstance.getInstance();
    }


    @Override
    public void pullCityData() {

    }

    @Override
    public void getCity() {

        Api api = retrofitClientInstance.create(Api.class);


        Call<CityModelList> call = api.getCity();



        call.enqueue(new Callback<CityModelList>() {
            @Override
            public void onResponse(Call<CityModelList> call, Response<CityModelList> response) {
                List<CityModel> cityList = response.body().getCityModelList();
                homeFragmentView.setCityList(cityList);
                for(CityModel c : response.body().getCityModelList()){
                    Log.e(TAG, "onResponse: "+response.body().getCityModelList().get(0).getCityname() );
                }
            }

            @Override
            public void onFailure(Call<CityModelList> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.getMessage());
            }
        });


    }

    @Override
    public void sendLatLong() {
        //homeFragmentView.

    }

    @Override
    public void getCityList() {



    }
}
