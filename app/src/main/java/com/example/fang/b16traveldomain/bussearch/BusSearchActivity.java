package com.example.fang.b16traveldomain.bussearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.adapters.BusSearchAdapter;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusSearchActivity extends AppCompatActivity implements BusSearchContract.BusSearchView,BusSearchListener{

    @BindView(R.id.rvBusSearch)
    RecyclerView mRecyclerView;

    private String TAG = BusSearchActivity.class.getSimpleName();
    BusSearchAdapter busSearchAdapter;
    private BusSearchPresenter mBusSearchPresenter;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search);


        ButterKnife.bind(this);

        setupBusSearchMVP();  //bind presenter
        setupViews();   //setup linear layout to recycler view

        getBusSearch();   //
        initToolBar();
        //Intent from Route Activity
        Intent intent = getIntent();
        id = intent.getStringExtra("routeId");

    }

    @Override
    public void setupBusSearchMVP() {
        mBusSearchPresenter = new BusSearchPresenter(this);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(BusSearchActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBusSearchActivity(BusInformationResponse busInformationResponse) {
        if(busInformationResponse != null){
            Log.d(TAG, "showBusSearchActivity: "+ busInformationResponse.getBusInformationList().get(0).getBusType());
            busSearchAdapter = new BusSearchAdapter(this,busInformationResponse.getBusInformationList(),BusSearchActivity.this);
            mRecyclerView.setAdapter(busSearchAdapter);
        } else {
            Log.d(TAG, "showBusSearchActivity: " + "response is null");
        }
        //onClick handler


    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void setupViews() {
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void getBusSearch() {
        mBusSearchPresenter.searchBus("2");

    }


    @Override
    public void onBusClicked(String busId) {
        //onBusClicked, pass busId to SeatSearch Activity
        Toast.makeText(this, "Bus is selected" + busId, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onBusClicked: " + busId );
    }

    public void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarBusSearch);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BusSearchActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
