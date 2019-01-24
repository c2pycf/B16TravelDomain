package com.example.fang.b16traveldomain.orderconfirmed;

public class OrderConfirmedPresenter implements OrderConfirmedContract.OrderConfirmedPresenter {
    OrderConfirmedContract.OrderConfirmedView mView;

    public OrderConfirmedPresenter(OrderConfirmedActivity activity) {
        this.mView = activity;
    }

    @Override
    public void onHomePageClicked() {
        mView.showHomePage();
    }
}
