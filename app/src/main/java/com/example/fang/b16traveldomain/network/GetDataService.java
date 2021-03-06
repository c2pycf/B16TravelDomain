package com.example.fang.b16traveldomain.network;


import com.example.fang.b16traveldomain.model.ApiResponseMsg;
import com.example.fang.b16traveldomain.model.Coupon;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface GetDataService {

    @GET("coupon_validation.php?")
    Call<List<Coupon>> getCoupons(@Query("couponno") String coupon);

    //response for api 10
    @GET("ticketcheckoutinfo.php?")
    Call<List<String>> getOrderResult(@QueryMap TicketInformation ticketInformation);

    //response for api 6 (bus search service by route id )
    @GET("businfo.php?")
    Call<BusInformationResponse> getBuses(@Query("routeid") String routeid);

    //response for api 7 (seat search by bus id)
    @GET("seatinfo.php?")
    Call<Seats> getBusSeats(@Query("busid") String busid);//reserve the seat
    @GET
    Call<ApiResponseMsg> reserveSeats(@Url String url);



}
