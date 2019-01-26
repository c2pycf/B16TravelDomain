package com.example.fang.b16traveldomain.ticketconfirmation;

import com.example.fang.b16traveldomain.model.TicketInformation;

public interface TicketDetailContract {

    interface TicketDetailView{
        void showToast(String msg);
        void showPaymentActivity(TicketInformation ticketInformation);

    }

    interface TicketDetailPresenter {
        void checkCoupon(String coupon, TicketInformation ticketInformation);

        void proceedToPayment( TicketInformation ticketInformation);

        void saveReservation(TicketInformation ticketInformation);
    }

}
