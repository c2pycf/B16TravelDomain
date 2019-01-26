package com.example.fang.b16traveldomain.seatsavailable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;

public class SeatsAvailableActivity extends AppCompatActivity implements SeatsAvailableContract.SeatsAvailableView {
    SeatsAvailablePresenter seatsAvailablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_available);

        setupSeatAvailableMVP();
        getSeats();
    }

    @Override
    public void setupSeatAvailableMVP() {
        seatsAvailablePresenter = new SeatsAvailablePresenter(this);
    }

    @Override
    public void showSeatAvailableActivity(Seats seats) {
        //setting up adapter
    }

    @Override
    public void setupSeatsView() {
        //setting up layoutmanager and recycler view

    }

    @Override
    public void getSeats() {
        //call presenter
        seatsAvailablePresenter.findSeats("103");
    }
}



