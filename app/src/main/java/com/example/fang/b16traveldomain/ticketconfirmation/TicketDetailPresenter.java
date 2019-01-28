package com.example.fang.b16traveldomain.ticketconfirmation;

import android.os.Build;
import android.util.Log;

import com.example.fang.b16traveldomain.model.Coupon;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.TicketInforDataResource;
import com.example.fang.b16traveldomain.model.dataresource.TicketInforRepository;
import com.example.fang.b16traveldomain.network.GetDataService;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TicketDetailPresenter implements TicketDetailContract.TicketDetailPresenter {

    private TicketDetailContract.TicketDetailView mView;
    private Retrofit mRetrofit;
    private GetDataService mDataService;
    private TicketInformation mTicketInformation;
    static private final String TAG = TicketDetailPresenter.class.getSimpleName();
    private TicketInforDataResource ticketInforDataResource;
    private String couponRate = "0";

    public TicketDetailPresenter(TicketDetailActivity activity) {
        this.mView = activity;
        mRetrofit = RetrofitClientInstance.getInstance();
        mDataService = mRetrofit.create(GetDataService.class);
        ticketInforDataResource = new TicketInforRepository(activity.getApplication());
        //Connect to local db
    }

    @Override
    public void checkCoupon(String coupon, TicketInformation ticketInformation) {
        mTicketInformation =ticketInformation;
        Call<List<Coupon>> call =  mDataService.getCoupons(coupon);
        call.enqueue(new Callback<List<Coupon>>() {
            @Override
            public void onResponse(Call<List<Coupon>> call, Response<List<Coupon>> response) {
                List<Coupon> coupons= response.body();
                if(coupons !=null) {
                    couponRate = coupons.get(0).getDiscount();
                    mView.showToast("Coupon applied");
                    //proceedToPayment(mTicketInformation);
                }
                else {
                    mView.showToast("Coupon invalid");
                }

            }

            @Override
            public void onFailure(Call<List<Coupon>> call, Throwable t) {
                mView.showToast(t.getMessage());
            }
        });

    }

    @Override
    public void proceedToPayment( TicketInformation ticketInformation) {
//        float fare = Float.parseFloat(mTicketInformation.getFare());
//        float rate = Float.parseFloat(couponRate);
//        float newFareFloat = fare*(100-rate)/100;
//        String newFare = Float.toString(newFareFloat);
//        mTicketInformation.setFare(newFare);
        mTicketInformation = ticketInformation;
        mTicketInformation.setCoupondiscount(couponRate);
        mView.showPaymentActivity(mTicketInformation);
    }

    @Override
    public void saveReservation(TicketInformation ticketInformation) {
        //save ticket information
        mTicketInformation = ticketInformation;
        LocalDateTime dateTime =null;
        if(mTicketInformation.getOrder_time()==null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.d(TAG,"Setting order_time");
                dateTime = LocalDateTime.now();
                FormatStyle formatStyle = FormatStyle.MEDIUM;
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(formatStyle, formatStyle);
                String orderTime = dateTime.format(formatter);
                mTicketInformation.setOrder_time(orderTime);
            }
            //insert new row
            ticketInforDataResource.saveTicketInfor(mTicketInformation);
            mView.showToast("Reservation information saved");
        }
        else {
            //update ticket
            ticketInforDataResource.updateTicketInfor(mTicketInformation);
            mView.showToast("Reservation information updated");
        }


    }
}
