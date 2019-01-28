package com.example.fang.b16traveldomain.paymentgateway;

import android.util.Log;

import com.example.fang.b16traveldomain.model.ApiResponseMsg;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.network.GetDataService;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentPresenter implements PaymentContract.PaymentPresenter{
    private PaymentContract.PaymentView mView;
    static private final String SIMPLIFY_API = "pk_test_Bb1D97K4vdVgMi3wmDkH3C8h";
    static private final String TAG = PaymentPresenter.class.getSimpleName();
    private Stripe stripe;
    private Retrofit mRetrofit;
    private GetDataService mDataService;
    private TicketInformation ticketInformation;

    public PaymentPresenter(PaymentActivity activity,TicketInformation ticketInformation) {
        this.mView = activity;
        stripe = new Stripe(activity,SIMPLIFY_API);
        mRetrofit = RetrofitClientInstance.getInstance();
        mDataService = mRetrofit.create(GetDataService.class);
        this.ticketInformation = ticketInformation;
    }

    @Override
    public void proceedPayment(Card card) {
        stripe.createToken(card, new TokenCallback() {
            @Override
            public void onError(Exception error) {
                Log.e(TAG,error.getMessage());
                mView.showToast(error.getMessage());
            }

            @Override
            public void onSuccess(Token token) {
                mView.showToast("Success");
                proceedOrder();

            }
        });
    }

    @Override
    public void proceedOrder() {
//        Call<List<String>> call = mDataService.getOrderResult(ticketInformation);
//        call.enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                mView.showToast(response.body().get(0));
//                mView.showConfirmedActivity();
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//
//                Log.e(TAG,t.getMessage());
//                mView.showToast(t.getMessage());
//            }
//        });
        String url = reserveSeatsApi();

        reserveSeats(url);

        mView.showConfirmedActivity();
    }

    @Override
    public void reserveSeats(String url) {
//        Call<ApiResponseMsg> call = mDataService.reserveSeats("http://rjtmobile.com/aamir/otr/android-app/chooseseat.php?busid=106&s1=1");
//        call.enqueue(new Callback<ApiResponseMsg>() {
//            @Override
//            public void onResponse(Call<ApiResponseMsg> call, Response<ApiResponseMsg> response) {
//                if (response.body()!=null) {
//                    String[] resposeMsg = response.body().getMsg();
//                    mView.showToast(resposeMsg[0]);
//                    if (resposeMsg[0].equals("reserved")){
//                        mView.showConfirmedActivity();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponseMsg> call, Throwable t) {
//                Log.e(TAG,"onFailure" + t.toString());
//                mView.showToast(t.getMessage());
//            }
//        });
        mView.showToast("Reserved");
    }

    @Override
    public String reserveSeatsApi() {
        String busId = ticketInformation.getBusid();
        String url_base = "http://rjtmobile.com/aamir/otr/android-app/chooseseat.php?busid="+busId;
        int seatsCount = ticketInformation.getPassangerSize();
        for(int i = 0 ; i<seatsCount;i++){
            String seat =  ticketInformation.getPassanger(i).getSelectedseat();
            url_base = url_base.concat( "&" + seat +"=1");
        }
        return url_base;
    }
}
