package com.example.fang.b16traveldomain.seatsavailable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.adapters.SeatsAvailableAdapter;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatsAvailableActivity extends AppCompatActivity implements SeatsAvailableContract.SeatsAvailableView {

    public static final String TAG_SEAT = SeatsAvailableActivity.class.getSimpleName() ;
    SeatsAvailablePresenter seatsAvailablePresenter;

    @BindView(R.id.recylcer_View_seat)
    RecyclerView recylcerViewSeat;

    SeatsAvailableAdapter mSeatsAvailableAdapter;

    BusInformation mBusInformation;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_available);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.seat_available_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select your seat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupSeatAvailableMVP();
        getSeats();
        setupSeatsView();

    }

    @Override
    public void setupSeatAvailableMVP() {
        seatsAvailablePresenter = new SeatsAvailablePresenter(this);
    }


    @Override
    public void setupSeatsView() {
        //setting up layoutmanager and recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recylcerViewSeat.setLayoutManager(linearLayoutManager);
        recylcerViewSeat.setItemAnimator(new DefaultItemAnimator());


    }
    @Override
    public void showSeatAvailableActivity(Seats seats, BusInformation busInformation) {
        //setting up adapter
        if(seats != null){
            mSeatsAvailableAdapter = new SeatsAvailableAdapter(this, seats.getSeats(), busInformation);
            recylcerViewSeat.setAdapter(mSeatsAvailableAdapter);
            Log.e(TAG_SEAT, "showSeatAvailableActivity:  "+ seats.getSeats().get(0).getTotalSeat());
        } else{
            Log.e(TAG_SEAT, "showSeatAvailableActivity:  " + "Error occurred " );
        }
    }

    @Override
    public void getSeats() {
        //call presenter, get bus id via intent here
      Bundle extras = getIntent().getExtras();
      if(extras != null){
          BusInformation busInformation = (BusInformation) getIntent().getSerializableExtra("bus");
          //String id = busInformation.getBusId();
          seatsAvailablePresenter.findSeats(busInformation);

          mBusInformation = busInformation;
      }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}



