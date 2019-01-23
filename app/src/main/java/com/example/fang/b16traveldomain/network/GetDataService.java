package com.example.fang.b16traveldomain.network;


public interface GetDataService {
import com.example.fang.b16traveldomain.model.Coupon;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("coupon_validation.php?")
    Call<List<Coupon>> getCoupons(@Query("couponno") String coupon);

    //bus search service by route id
    @GET("businfo.php?")
    Call<BusInformationResponse> getBuses(@Query("routeid") String routeid);

}
