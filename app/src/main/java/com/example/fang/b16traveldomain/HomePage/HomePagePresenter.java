package com.example.fang.b16traveldomain.HomePage;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class HomePagePresenter implements  HomePageContract.HomeFragmentPresenter {

    HomePageContract.HomeFragmentView homeFragmentView ;

    Retrofit retrofitClientInstance;
    // = RetrofitClientInstance.getInstance();




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


        Call<cityModelList> call = api.getCity();



        call.enqueue(new Callback<cityModelList>() {
            @Override
            public void onResponse(Call<cityModelList> call, Response<cityModelList> response) {
                List<CityModel> cityList = response.body().getCityModelList();
                homeFragmentView.setCityList(cityList);
                for(CityModel c : response.body().getCityModelList()){
                    Log.e(TAG, "onResponse: "+response.body().getCityModelList().get(0).getCityname() );
                }
            }

            @Override
            public void onFailure(Call<cityModelList> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.getMessage());
            }
        });


    }

    @Override
    public void sendLatLong() {

    }
}
