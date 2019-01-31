package com.example.fang.b16traveldomain.orderconfirmed

interface OrderConfirmedContract {
    interface OrderConfirmedView {
        fun showHomePage()

        fun sentEmail()
    }

    interface OrderConfirmedPresenter {
        fun onHomePageClicked()
    }
}
