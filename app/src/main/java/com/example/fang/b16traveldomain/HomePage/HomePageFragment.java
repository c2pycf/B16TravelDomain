package com.example.fang.b16traveldomain.HomePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class HomePageFragment extends Fragment implements  HomePageContract.HomeFragmentView{

    Spinner start_city_spinner, destination_city_spinner;
    EditText et_date;
    Button btn_search;
    String TAG = "HomeFragment";


    String BASE_URL = "http://rjtmobile.com/aamir/otr/android-app/";

    String Date;

    HomePagePresenter homePagePresenter;

    String start_city , destination_city;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_fragment,container,false);
        start_city_spinner = view.findViewById(R.id.spinner_start_city);
        destination_city_spinner = view.findViewById(R.id.spinner_destination_city);
        et_date = view.findViewById(R.id.et_date_home);
        btn_search = view.findViewById(R.id.btn_search_home);

        Date = et_date.getText().toString();



//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();


        homePagePresenter = new HomePagePresenter(this);

        homePagePresenter.getCity();




        ////////// 2nd part on search button click

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start_city = String.valueOf(start_city_spinner.getSelectedItem());



            }
        });








        return view;
    }

    @Override
    public void HomePageView() {

    }

    @Override
    public void setCityList(List<CityModel> cityList) {
        List<String> cityList_String = new ArrayList<>();
        for(int i =0 ; i <cityList.size();i++){
            cityList_String.add(cityList.get(i).getCityname());
        }

        //adapter
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (getContext(),android.R.layout.simple_spinner_item , cityList_String);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        start_city_spinner.setAdapter(dataAdapter);
        destination_city_spinner.setAdapter(dataAdapter);




    }
}
