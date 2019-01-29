package com.example.fang.b16traveldomain.homePage;

import com.example.fang.b16traveldomain.routeActivity.RouteList;
import com.example.fang.b16traveldomain.routeActivity.RouteModel;

import java.util.List;

/**
 * Contract for Home Page fragment
 */
public interface HomePageContract  {

    interface HomeFragmentView{
        void HomePageView();
        void setCityList(List<CityModel> cityList);
        void setRoute();
        void displayMessege(String messege);

        void setRouteList(RouteList route_list);

        void datePicked(String datePicked);
    }

    interface  HomeFragmentPresenter{
        void pullCityData();

        void getCity();

        void sendLatLong();
        void getCityList();

        void getRoute(String start_Lattitude, String start_Longitude, String destination_Lattitude, String destination_Longitude);

        void setUpDataPicker();

        void initDate();

        void saveDate(String journyDate);
    }


}
