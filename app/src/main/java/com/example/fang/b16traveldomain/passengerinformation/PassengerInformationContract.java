package com.example.fang.b16traveldomain.passengerinformation;

import android.view.View;

import com.example.fang.b16traveldomain.adapters.SeatsDetailAdapter;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;

import java.util.ArrayList;

public interface PassengerInformationContract {
    interface PassengerInformationView{

        void setAdapter(SeatsDetailAdapter adapter);

        void showConfirmPage(TicketInformation mTicketInformation);
    }

    interface passengerInformationPresenter {
        void loadFromSavedReservation(TicketInformation ticketInformation);
        
        void getPassengerInformationView(View view);

        void setNewTicketInfor(ArrayList<String> seats, BusInformation busInformation);
        
        void setNewPassengerInfor();

        void showConfirmPage();
    }
}
