package com.example.fang.b16traveldomain.paymentgateway;

import android.util.Log;

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

    public PaymentPresenter(PaymentActivity activity) {
        this.mView = activity;
        stripe = new Stripe(activity,SIMPLIFY_API);
        mRetrofit = RetrofitClientInstance.getInstance();
        mDataService = mRetrofit.create(GetDataService.class);
    }

    @Override
    public void proceedPayment(Card card, final TicketInformation ticketInformation) {
        stripe.createToken(card, new TokenCallback() {
            @Override
            public void onError(Exception error) {
                Log.e(TAG,error.getMessage());
                mView.showToast(error.getMessage());
            }

            @Override
            public void onSuccess(Token token) {
                mView.showToast("Success");
                proceedOrder(ticketInformation);

            }
        });
    }

    @Override
    public void proceedOrder(final TicketInformation ticketInformation) {
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
    }
}
