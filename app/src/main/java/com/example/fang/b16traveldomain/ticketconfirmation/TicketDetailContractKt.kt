package com.example.fang.b16traveldomain.ticketconfirmation

import com.example.fang.b16traveldomain.model.TicketInformation

interface TicketDetailContractKt{
    interface TicketDetailView{
        fun showToast(msg:String)
        fun showPaymentActivity(ticketInformation: TicketInformation)
    }

    interface TicketDetailPresenter{
        fun checkCoupon(coupon : String, ticketInformation: TicketInformation)

        fun proceedToPayment(ticketInformation: TicketInformation)

        fun saveReservation(ticketInformation: TicketInformation)
    }
}