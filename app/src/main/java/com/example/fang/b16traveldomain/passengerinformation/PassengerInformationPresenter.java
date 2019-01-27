package com.example.fang.b16traveldomain.passengerinformation;

import android.view.View;
import android.widget.EditText;

import com.example.fang.b16traveldomain.adapters.SeatsDetailAdapter;
import com.example.fang.b16traveldomain.model.Passenger;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.TicketInforDataResource;
import com.example.fang.b16traveldomain.model.dataresource.UserDataSource;
import com.example.fang.b16traveldomain.model.dataresource.UserRepository;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;

import java.util.ArrayList;

public class PassengerInformationPresenter implements PassengerInformationContract.passengerInformationPresenter {
    public EditText mail;
    public EditText phone;
    public EditText[] name;
    public EditText[] age;
    public String[] gender;

    private int passengerCount;
    private PassengerInformationContract.PassengerInformationView mView;
    
    private TicketInformation mTicketInformation;
    private UserRepository userDataSource;
    TicketInforDataResource ticketInforDataResource;

    public PassengerInformationPresenter(PassengerInformationActivity activity) {
        this.mView = activity;
        userDataSource = new UserDataSource(activity);
    }


    @Override
    public void loadFromSavedReservation(TicketInformation ticketInformation) {
        mTicketInformation = ticketInformation;
        passengerCount = ticketInformation.getPassangerSize();
        SeatsDetailAdapter adapter = new SeatsDetailAdapter(ticketInformation,this);
        mView.setAdapter(adapter);
    }

    @Override
    public void getPassengerInformationView(View view) {

    }

    @Override
    public void setNewTicketInfor(ArrayList<String> seats, BusInformation busInformation) {
        mTicketInformation = new TicketInformation();
        mTicketInformation.setJournydate( userDataSource.getDate());
        mTicketInformation.setRoute_name(userDataSource.getRoute());
        //set time
        //get start time
        //set route ID
        mTicketInformation.setBoardingtime(busInformation.getBusDepartureTime());
        //get end time
        mTicketInformation.setDroppingtime(busInformation.getDropingTime());
        //get duration
        mTicketInformation.setDuration(busInformation.getJourneyDuration());
        passengerCount = seats.size();
        for (int i=0;i<passengerCount;i++){
            Passenger passenger = new Passenger(seats.get(i),null,null,null);
            mTicketInformation.addPassanger(passenger);
        }
    }

    private String[] convertDate(String journeyDate) {
        return journeyDate.split("/s");
    }

    @Override
    public void setNewPassengerInfor() {
        for(int i=0;i<passengerCount;i++){
            mTicketInformation.getPassanger(i).setPassengername(name[i].getText().toString());
            mTicketInformation.getPassanger(i).setPassengerage(age[i].getText().toString());
            mTicketInformation.getPassanger(i).setPassengername(gender[i]);
        }
    }

    @Override
    public void showConfirmPage() {
        mView.showConfirmPage(mTicketInformation);
    }


}
