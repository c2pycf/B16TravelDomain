package com.example.fang.b16traveldomain.model.dataresource.localdataresource;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference implements LocalUserResource{

    SharedPreferences userPreference;
    public SharedPreference(Context context) {
        userPreference = context.getSharedPreferences("srs_user",Context.MODE_PRIVATE);

    }

    @Override
    public void saveUser() {

    }

    @Override
    public void saveDate(String date) {

    }

    @Override
    public void getUser() {

    }

    @Override
    public void getDate() {

    }
}
