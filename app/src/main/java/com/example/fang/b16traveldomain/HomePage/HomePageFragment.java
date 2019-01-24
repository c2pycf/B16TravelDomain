package com.example.fang.b16traveldomain.HomePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePageFragment extends Fragment {

    Spinner start_city_spinner, destination_city_spinner;
    EditText et_date;
    Button btn_search;
    String TAG = "HomeFragment";

    RetrofitClientInstance retrofitClientInstance;
    String BASE_URL = "http://rjtmobile.com/aamir/otr/android-app/";


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


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);


        Call<cityModelList> call = api.getCity();


        call.enqueue(new Callback<cityModelList>() {
            @Override
            public void onResponse(Call<cityModelList> call, Response<cityModelList> response) {
                Log.e(TAG, "onResponse: "+response.body().getCityModelList().get(0).getCityname() );
            }

            @Override
            public void onFailure(Call<cityModelList> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.getMessage());
            }
        });








        return view;
    }
}
