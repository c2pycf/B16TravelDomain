package com.example.fang.b16traveldomain.paymentgateway;

import com.example.fang.b16traveldomain.model.TicketInformation;
import com.stripe.android.model.Card;

public interface PaymentContract {
    interface PaymentView{
        void createCard();

        void showToast(String msg);

        void showConfirmedActivity();
    }

    interface PaymentPresenter{
        void proceedPayment(Card card, TicketInformation ticketInformation);

        void proceedOrder(TicketInformation ticketInformation);
    }
}
