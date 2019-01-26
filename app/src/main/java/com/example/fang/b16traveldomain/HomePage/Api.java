package com.example.fang.b16traveldomain.HomePage;

import retrofit2.Call;
import retrofit2.http.POST;

public interface Api {


    @POST("city.php?")
    Call<CityModelList> getCity();
}
