package com.example.fang.b16traveldomain.ticketConfirmation;

public interface TicketDetailContract {
<<<<<<< Updated upstream
=======
    interface TicketDetailView{
        void showToast(String msg);
        void showPaymentActivity(TicketInformation ticketInformation);

    }

    interface TicketDetailPresenter {
        void checkCoupon(String coupon, TicketInformation ticketInformation);

        void proceedToPayment(String couponRate);

        void saveReservation(TicketInformation ticketInformation);
    }
>>>>>>> Stashed changes
}
