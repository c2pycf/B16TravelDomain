package com.example.fang.b16traveldomain.passengerinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.adapters.SeatsDetailAdapter;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.ticketconfirmation.TicketDetailActivity;

import java.util.ArrayList;

public class PassengerInformationActivity extends AppCompatActivity implements PassengerInformationContract.PassengerInformationView {
    static private String TICKET_INFORMATION_TAG = "ticket_information";
    static private String BUS_INFORMATION_TAG = "bus_infor";
    static private final String TAG = PassengerInformationActivity.class.getSimpleName();
    RecyclerView recyclerView;
    PassengerInformationPresenter mPresenter;
    Button btConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_infromation);
        mPresenter = new PassengerInformationPresenter(this);
        recyclerView = findViewById(R.id.passenger_information_recycle);
        btConfirm = findViewById(R.id.bt_passenger_confirmed);
        getIntentFromPreviousActivity();
        setRecyclerView();
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.setNewPassengerInfor();
                mPresenter.showConfirmPage();
            }
        });

    }

    private void getIntentFromPreviousActivity() {
        Intent intent = getIntent();
        if(intent.getSerializableExtra("saved_reservation")!=null){
            TicketInformation ticketInformation = (TicketInformation) intent.getSerializableExtra("saved_reservation");
            mPresenter.loadFromSavedReservation(ticketInformation);
        }
        else if (intent.getStringArrayListExtra("seats")!=null&&intent.getSerializableExtra(BUS_INFORMATION_TAG)!=null){
            ArrayList<String> seats = intent.getStringArrayListExtra("seats");
            BusInformation busInformation = (BusInformation) intent.getSerializableExtra(BUS_INFORMATION_TAG);
            mPresenter.setNewTicketInfor(seats, busInformation);
        }
        else {
            //TestFunction
            mockingTestData();
        }
    }

    private void mockingTestData() {
        Log.d(TAG,"Start Mocking data");
        ArrayList<String> seats =new ArrayList<>();
        seats.add("s1");
        seats.add("s3");
        BusInformation busInformation = new BusInformation("105", "101", "Air",

                "10:00AM", "5h10m", "5000",

                "9:50AM", "10:00PM");
        mPresenter.setNewTicketInfor(seats, busInformation);

    }

    private void setRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void setAdapter(SeatsDetailAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showConfirmPage(TicketInformation mTicketInformation) {
        Intent intent = new Intent(PassengerInformationActivity.this,TicketDetailActivity.class);
        intent.putExtra(TICKET_INFORMATION_TAG,mTicketInformation);
        startActivity(intent);
    }
}
