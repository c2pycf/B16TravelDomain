package com.example.fang.b16traveldomain.ticketConfirmation;

import android.util.Log;

import com.example.fang.b16traveldomain.model.Coupon;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.network.GetDataService;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TicketDetailPresenter implements TicketDetailContract.TicketDetialPresenter{

    private TicketDetailContract.TicketDetailView mView;
    private Retrofit mRetrofit;
    private GetDataService mDataService;
    private TicketInformation mTicketInformation;
    static private final String TAG = TicketDetailPresenter.class.getSimpleName();

    public TicketDetailPresenter(TicketDetailActivity activity) {
        this.mView = activity;
        mRetrofit = RetrofitClientInstance.getInstance();
        mDataService = mRetrofit.create(GetDataService.class);
        //Connect to local db
    }

    @Override
    public void checkCoupon(String coupon, TicketInformation ticketInformation) {
        mTicketInformation =ticketInformation;
        Call<List<Coupon>> call =  mDataService.getCoupons(coupon);
        call.enqueue(new Callback<List<Coupon>>() {
            @Override
            public void onResponse(Call<List<Coupon>> call, Response<List<Coupon>> response) {
                Log.d(TAG,response.toString());
                List<Coupon> coupons= response.body();
                if(coupons !=null) {
                    String couponRate = coupons.get(0).getDiscount();
                    proceedToPayment(couponRate);
                }
                else {
                    mView.showToast("Coupon invalid");
                }

            }

            @Override
            public void onFailure(Call<List<Coupon>> call, Throwable t) {

            }
        });

    }

    @Override
    public void proceedToPayment(String couponRate) {
//        float fare = Float.parseFloat(mTicketInformation.getFare());
//        float rate = Float.parseFloat(couponRate);
//        float newFareFloat = fare*(100-rate)/100;
//        String newFare = Float.toString(newFareFloat);
//        mTicketInformation.setFare(newFare);
        mTicketInformation.setCoupondiscount(couponRate);
        mView.showPaymentActivity(mTicketInformation);
    }

    @Override
    public void saveReservation(TicketInformation ticketInformation) {
        //save ticket information
        mTicketInformation = ticketInformation;

    }
}
