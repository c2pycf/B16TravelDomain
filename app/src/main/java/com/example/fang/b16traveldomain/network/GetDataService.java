package com.example.fang.b16traveldomain.network;

import com.example.fang.b16traveldomain.model.Coupon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("coupon_validation.php?")
    Call<List<Coupon>> getCoupons(@Query("couponno") String coupon);
}
