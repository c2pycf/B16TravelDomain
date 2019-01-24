package com.example.fang.b16traveldomain.bussearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.adapters.BusSearchAdapter;
import com.example.fang.b16traveldomain.model.dataResource.busInformation.BusInformationResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusSearchActivity extends AppCompatActivity implements BusSearchContract.BusSearchView{

    @BindView(R.id.rvBusSearch)
    RecyclerView rvBusView;

    private String TAG = BusSearchActivity.class.getSimpleName();
    BusSearchAdapter busSearchAdapter;
    private BusSearchPresenter mBusSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search);

        ButterKnife.bind(this);
        mBusSearchPresenter = new BusSearchPresenter(this);


        mBusSearchPresenter.searchBus("2");


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
        //busSearchAdapter = new BusSearchAdapter();
    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void setupViews() {

    }

}
