package com.example.fang.b16traveldomain.ticketConfirmation;

import com.example.fang.b16traveldomain.model.TicketInformation;

public interface TicketDetailContract {
    interface TicketDetailView{
        void showToast(String msg);

        void showPaymentActivity(TicketInformation ticketInformation);

    }

    interface TicketDetialPresenter{
        void checkCoupon(String coupon, TicketInformation ticketInformation);

        void proceedToPayment(String couponRate);

        void saveReservation(TicketInformation ticketInformation);
    }
}
