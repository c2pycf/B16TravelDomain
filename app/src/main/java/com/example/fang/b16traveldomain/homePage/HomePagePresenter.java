package com.example.fang.b16traveldomain.homePage;

import android.app.DatePickerDialog;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.DatePicker;

import com.example.fang.b16traveldomain.model.dataresource.UserDataSource;
import com.example.fang.b16traveldomain.model.dataresource.UserRepository;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;
import com.example.fang.b16traveldomain.routeActivity.RouteApi;
import com.example.fang.b16traveldomain.routeActivity.RouteContract;
import com.example.fang.b16traveldomain.routeActivity.RouteList;
import com.example.fang.b16traveldomain.routeActivity.RouteModel;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.support.constraint.Constraints.TAG;

public class HomePagePresenter implements HomePageContract.HomeFragmentPresenter {

    HomePageContract.HomeFragmentView homeFragmentView;

    //Retrofit retrofitClientInstance;
    // = RetrofitClientInstance.getInstance();

    CityModelList cityModelList;
    //RouteContract.RouteView routeView;
    Retrofit retrofit;

    RouteList route_List;

    Context context;

    String TAG = "HomePagePresenter";

    Calendar now;

    UserRepository userDataSource;


    public HomePagePresenter(HomePageFragment fragment) {
        this.homeFragmentView = fragment;
        context = fragment.getContext();
        this.retrofit = RetrofitClientInstance.getInstance();
        now = Calendar.getInstance();
        userDataSource = new UserDataSource(context);
    }


    @Override
    public void pullCityData() {

    }

    @Override
    public void getCity() {

        Api api = retrofit.create(Api.class);


        Call<CityModelList> call = api.getCity();


        call.enqueue(new Callback<CityModelList>() {
            @Override
            public void onResponse(Call<CityModelList> call, Response<CityModelList> response) {
                List<CityModel> cityList = response.body().getCityModelList();
                homeFragmentView.setCityList(cityList);
                for (CityModel c : response.body().getCityModelList()) {
                    Log.e(TAG, "onResponse: " + response.body().getCityModelList().get(0).getCityname());
                }
            }

            @Override
            public void onFailure(Call<CityModelList> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.getMessage());
            }
        });


    }

    @Override
    public void sendLatLong() {
        //homeFragmentView.

    }

    @Override
    public void getCityList() {


    }

    @Override
    public void getRoute(String start_Lattitude, String start_Longitude, String destination_Lattitude, String destination_Longitude) {
        RouteApi routeApi = retrofit.create(RouteApi.class);
        Log.e(TAG, "getRoute: " + start_Lattitude + " " + start_Longitude + " " + destination_Lattitude + " " + destination_Longitude);

        Call<RouteList> call = routeApi.getRoute(start_Lattitude, start_Longitude, destination_Lattitude, destination_Longitude);

        call.enqueue(new Callback<RouteList>() {
            @Override
            public void onResponse(Call<RouteList> call, Response<RouteList> response) {
                Log.e(TAG, "onResponse: of getRoute()" + response.body());
                if (response.body().getRouteModelList() != null) {
                    Log.e(TAG, "onResponse: get route " + response.body().getRouteModelList().get(0).getRoute_startfrom());
                    //routeView.set_route(response.body().routeModelList);
                    //homeFragmentView
                    route_List = response.body();
                    homeFragmentView.setRouteList(route_List);

                } else {
                    Log.e(TAG, "onResponse: " + "no route found");
                    homeFragmentView.displayMessege("no route found");

                }

            }

            @Override
            public void onFailure(Call<RouteList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

        //return route_List;

    }

    @Override
    public void setUpDataPicker() {
//        new DatePickerDialog(
//                requireActivity(),
//                (view, year, month, dayOfMonth) -> new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                            //String date = "You picked the following date: " + dayOfMonth + "/" + (++month) + "/" + year;
//                            String datePicked = converLocalDate(year, month + 1, dayOfMonth);
//                            Log.d(TAG, "Date picked: " + datePicked);
//                            homeFragmentView.datePicked(datePicked);
//
//                        }
//                    }
//                },
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DAY_OF_MONTH)
//        ).show();
    }

    @Override
    public void initDate() {
            int year = now.get(Calendar.YEAR);
            int monthOfYear = now.get(Calendar.MONTH);
            int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
            String date = converLocalDate(year,monthOfYear,dayOfMonth);
            Log.d(TAG, "Date picked: " + date);
            homeFragmentView.datePicked(date);

    }

    @Override
    public void saveDate(String journyDate) {
        userDataSource.saveDate(journyDate);
    }

    public String converLocalDate(int year, int monthOfYear, int dayOfMonth) {
        String datePicked="Jan 1 1";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate localDate = LocalDate.of(year, monthOfYear+1, dayOfMonth);
            Log.d(TAG, "Date convert " + localDate.getMonth() + ", " + localDate.getDayOfMonth()+ ", "+localDate.getDayOfWeek());
            datePicked = localDate.getMonth() + " " + localDate.getDayOfMonth()+ " "+localDate.getDayOfWeek();
        }
        return datePicked;
    }

    private Context requireActivity() {
        return context;
    }


}
