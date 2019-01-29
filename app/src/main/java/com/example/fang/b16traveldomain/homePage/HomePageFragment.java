package com.example.fang.b16traveldomain.homePage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fang.b16traveldomain.MainActivity;
import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.routeActivity.RouteActivity;
import com.example.fang.b16traveldomain.routeActivity.RouteList;
//import  com.example.fang.b16traveldomain.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomePageFragment extends Fragment implements HomePageContract.HomeFragmentView {


    Spinner start_city_spinner, destination_city_spinner;
    TextView tv_date;
    Button btn_search, btn_journey_date;
    String TAG = "HomeFragment";

    RouteList routeList;

    String id, routename, route_startfrom, route_destination, route_startpoint_latitude, route_startpoint_longitude, route_endpoint_latitude,
            route_endpoint_longiude;


    String BASE_URL = "http://rjtmobile.com/aamir/otr/android-app/";

    String Date;

    HomePagePresenter homePagePresenter;

    CardView datePicker;
    TextView cardWeek, cardDate, cardMonth;

    Calendar calendar;
    DatePickerDialog datePickerDialog;
    String journyDate;

    //String start_city , destination_city;
    int start_city_index, destination_city_index;
//    CityModelList cityList;
//    CityModel cityModel;
Calendar now;

    String start_lattitude, start_longitude, destination_lattitude, destination_longitude;

    public HomePageFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_fragment, container, false);
        start_city_spinner = view.findViewById(R.id.spinner_start_city);
        destination_city_spinner = view.findViewById(R.id.spinner_destination_city);
        tv_date = (TextView) view.findViewById(R.id.tv_date_of_journey_home);
        btn_search = view.findViewById(R.id.btn_search_home);
        btn_journey_date = view.findViewById(R.id.btn_journey_date);
        datePicker = view.findViewById(R.id.data_picker_card);
        cardWeek = view.findViewById(R.id.tv_week_picker_card);
        cardDate = view.findViewById(R.id.tv_date_date_picker);
        cardMonth = view.findViewById(R.id.tv_month_picker_card);
        getActivity().setTitle(R.string.nav_header_subtitle);

        homePagePresenter = new HomePagePresenter(this);
        now = Calendar.getInstance();

        homePagePresenter.getCity();
        homePagePresenter.initDate();

        btn_journey_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int year = calendar.get(Calendar.YEAR);

                Date = String.valueOf(month+1) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_date.setText(month+1 + "/" + dayOfMonth + "/" + year);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                            String datePicked = homePagePresenter.converLocalDate(year, month , dayOfMonth);
                            Log.d(TAG, "Date picked: " + datePicked);
                            datePicked(datePicked);

                        }


                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });



        ////////// 2nd part on search button click


        return view;
    }


    @Override
    public void HomePageView() {

    }


    @Override
    public void setCityList(final List<CityModel> cityList) {
        List<String> cityList_String = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            cityList_String.add(cityList.get(i).getCityname());
        }

        //adapter
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.simple_spinner_item, cityList_String);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        start_city_spinner.setAdapter(dataAdapter);
        destination_city_spinner.setAdapter(dataAdapter);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePagePresenter.saveDate(journyDate);

//                start_city = String.valueOf(start_city_spinner.getSelectedItem());
//                destination_city = String.valueOf(destination_city_spinner.getSelectedItem());

                start_city_index = start_city_spinner.getSelectedItemPosition();
                destination_city_index = destination_city_spinner.getSelectedItemPosition();

                start_lattitude = cityList.get(start_city_index).getLattitude();
                start_longitude = cityList.get(start_city_index).getLongitude();

                destination_longitude = cityList.get(destination_city_index).getLongitude();
                destination_lattitude = cityList.get(destination_city_index).getLattitude();

//                Intent intent = new Intent(getContext(), RouteActivity.class);
//
//                intent.putExtra("start_lattitude", start_lattitude);
//                intent.putExtra("start_longitude", start_longitude);
//                intent.putExtra("destination_longitude", destination_longitude);
//                intent.putExtra("destination_lattitude", destination_lattitude);
//
//                startActivity(intent);

                homePagePresenter.getRoute(start_lattitude, start_longitude, destination_lattitude, destination_longitude);


            }
        });


    }

    @Override
    public void setRoute() {

    }

    @Override
    public void displayMessege(String messege) {
        Toast.makeText(getContext(), messege, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setRouteList(RouteList routeList) {
        id = routeList.getRouteModelList().get(0).getId();
        routename = routeList.getRouteModelList().get(0).getRoutename();
        route_startfrom = routeList.getRouteModelList().get(0).getRoute_startfrom();
        route_destination = routeList.getRouteModelList().get(0).getRoute_destination();
        route_startpoint_latitude = routeList.getRouteModelList().get(0).getRoute_startpoint_latitude();
        route_startpoint_longitude = routeList.getRouteModelList().get(0).getRoute_startpoint_longitude();
        route_endpoint_latitude = routeList.getRouteModelList().get(0).getRoute_endpoint_latitude();
        route_endpoint_longiude = routeList.getRouteModelList().get(0).getRoute_endpoint_longiude();

        Intent intent = new Intent(getContext(), RouteActivity.class);

        intent.putExtra("route_startfrom", route_startfrom);
        intent.putExtra("route_destination", route_destination);
        intent.putExtra("route_startpoint_latitude", route_startpoint_latitude);
        intent.putExtra("route_startpoint_longitude", route_startpoint_longitude);
        intent.putExtra("route_endpoint_latitude", route_endpoint_latitude);
        intent.putExtra("route_endpoint_longiude", route_endpoint_longiude);
        intent.putExtra("id", id);


        startActivity(intent);

    }

    @Override
    public void datePicked(String datePicked) {
        journyDate = datePicked;
        String[] dateArray = datePicked.split(" ");
        cardMonth.setText(dateArray[0]);
        cardDate.setText(dateArray[1]);
        cardWeek.setText(dateArray[2]);
    }


//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        String date = "You picked the following date: " + dayOfMonth + "/" + (++month) + "/" + year;
//        Log.d(TAG, "Date set: " + date);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            //String date = "You picked the following date: " + dayOfMonth + "/" + (++month) + "/" + year;
//            String datePicked = homePagePresenter.converLocalDate(year, month + 1, dayOfMonth);
//            Log.d(TAG, "Date picked: " + datePicked);
//            datePicked(datePicked);
//
//        }
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        datePicker.setOnClickListener(v -> {
            //homePagePresenter.setUpDataPicker();
            new DatePickerDialog(
                    getContext(),
                    (view1, year, month, dayOfMonth) -> new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            String date = "You picked the following date: " + dayOfMonth + "/" + (++month) + "/" + year;
                            tv_date.setText(date);
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                                String datePicked = homePagePresenter.converLocalDate(year, month + 1, dayOfMonth);
                                Log.d(TAG, "Date picked: " + datePicked);
                                datePicked(datePicked);

                            }
                        }
                    },
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            ).show();

        });
    }
}
