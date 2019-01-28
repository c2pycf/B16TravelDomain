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
import java.util.List;

public class PassengerInformationPresenter implements PassengerInformationContract.passengerInformationPresenter {
    public EditText mail;
    public EditText phone;
    public List<EditText> name;
    public List<EditText> age;
    public List<String> gender;

    private int passengerCount;
    private PassengerInformationContract.PassengerInformationView mView;
    
    private TicketInformation mTicketInformation;
    private UserRepository userDataSource;
    TicketInforDataResource ticketInforDataResource;

    public PassengerInformationPresenter(PassengerInformationActivity activity) {
        this.mView = activity;
        userDataSource = new UserDataSource(activity);
        name = new ArrayList<>();
        age = new ArrayList<>();
        gender = new ArrayList<>();
    }


    @Override
    public void loadFromSavedReservation(TicketInformation ticketInformation) {
        mTicketInformation = ticketInformation;
        passengerCount = ticketInformation.getPassangerSize();
        SeatsDetailAdapter adapter = new SeatsDetailAdapter(mTicketInformation,this);
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
        mTicketInformation.setBusid(busInformation.getBusId());
        mTicketInformation.setBoardingtime(busInformation.getBusDepartureTime());
        //get end time
        mTicketInformation.setDroppingtime(busInformation.getDropingTime());
        //get duration
        mTicketInformation.setDuration(busInformation.getJourneyDuration());
        passengerCount = seats.size();
        String singleFee = busInformation.getFare();
        mTicketInformation.setFare(Double.toString(calculateTotle(singleFee)));

        for (int i=0;i<passengerCount;i++){
            Passenger passenger = new Passenger(seats.get(i),null,null,"Male");
            mTicketInformation.addPassanger(passenger);
        }
        SeatsDetailAdapter adapter = new SeatsDetailAdapter(mTicketInformation,this);
        mView.setAdapter(adapter);
    }

    private double calculateTotle(String single) {
        return Double.parseDouble(single)*passengerCount;

    }

    private String[] convertDate(String journeyDate) {
        return journeyDate.split("/s");
    }

    @Override
    public void setNewPassengerInfor() {
        for(int i=0;i<passengerCount;i++){
            mTicketInformation.getPassanger(i).setPassengername(name.get(i).getText().toString());
            mTicketInformation.getPassanger(i).setPassengerage(age.get(i).getText().toString());
            mTicketInformation.getPassanger(i).setPassengergender(gender.get(i));
        }
        //null
        mTicketInformation.setPassengeremail(mail.getText().toString());
        mTicketInformation.setPassengermobile(phone.getText().toString());
    }

    @Override
    public void showConfirmPage() {
        mView.showConfirmPage(mTicketInformation);
    }

}
