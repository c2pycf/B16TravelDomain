package com.example.fang.b16traveldomain.paymentgateway;

public interface PaymentContract {
    interface PaymentView{
        void createCardToken(Card card);
    }

    interface PaymentPresenter{}
}
