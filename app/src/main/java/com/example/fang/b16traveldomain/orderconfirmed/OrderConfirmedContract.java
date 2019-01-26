package com.example.fang.b16traveldomain.orderconfirmed;

public interface OrderConfirmedContract {
    interface OrderConfirmedView{
        void showHomePage();
    }

    interface OrderConfirmedPresenter{
        void onHomePageClicked();
    }
}
