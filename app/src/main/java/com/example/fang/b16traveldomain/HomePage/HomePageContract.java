package com.example.fang.b16traveldomain.HomePage;

import java.util.List;

/**
 * Contract for Home Page fragment
 */
public interface HomePageContract  {

    interface HomeFragmentView{
        void HomePageView();
        void setCityList(List<CityModel> cityList);
    }

    interface  HomeFragmentPresenter{
        void pullCityData();

        void getCity();

        void sendLatLong();
        void getCityList();
    }


}
