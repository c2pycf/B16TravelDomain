package com.example.fang.b16traveldomain.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.routeActivity.RouteActivity;
//import  com.example.fang.b16traveldomain.R;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment implements  HomePageContract.HomeFragmentView{

    Spinner start_city_spinner, destination_city_spinner;
    EditText et_date;
    Button btn_search;
    String TAG = "HomeFragment";


    String BASE_URL = "http://rjtmobile.com/aamir/otr/android-app/";

    String Date;

    HomePagePresenter homePagePresenter;

    String start_city , destination_city;
    int start_city_index, destination_city_index;
//    CityModelList cityList;
//    CityModel cityModel;

    String start_lattitude, start_longitude, destination_lattitude, destination_longitude;




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








        return view;
    }

    @Override
    public void HomePageView() {

    }

    @Override
    public void setCityList(final List<CityModel> cityList) {
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

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                start_city = String.valueOf(start_city_spinner.getSelectedItem());
//                destination_city = String.valueOf(destination_city_spinner.getSelectedItem());


                start_city_index = start_city_spinner.getSelectedItemPosition();
                destination_city_index = destination_city_spinner.getSelectedItemPosition();

                start_lattitude = cityList.get(start_city_index).getLattitude();
                start_longitude = cityList.get(start_city_index).getLongitude();

                destination_longitude = cityList.get(destination_city_index).getLongitude();
                destination_lattitude = cityList.get(destination_city_index).getLattitude();

                Intent intent = new Intent(getContext(), RouteActivity.class);

                intent.putExtra("start_lattitude", start_lattitude);
                intent.putExtra("start_longitude", start_longitude);
                intent.putExtra("destination_longitude", destination_longitude);
                intent.putExtra("destination_lattitude", destination_lattitude);

                startActivity(intent);







            }
        });






    }
}
