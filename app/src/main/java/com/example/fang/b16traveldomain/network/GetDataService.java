package com.example.fang.b16traveldomain.network;

import com.example.fang.b16traveldomain.model.Coupon;
import com.example.fang.b16traveldomain.model.TicketInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GetDataService {

    @GET("coupon_validation.php?")
    Call<List<Coupon>> getCoupons(@Query("couponno") String coupon);

    //response for api 10
    @GET("ticketcheckoutinfo.php?")
    Call<List<String>> getOrderResult(@QueryMap TicketInformation ticketInformation);
}
