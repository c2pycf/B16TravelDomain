package com.example.fang.b16traveldomain.model.dataresource.localdataresource;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference implements LocalUserResource{

    SharedPreferences userPreference;
    static private final String PREFERENCE_NAME = "srs_user";
    static private final String USER_ID = "user_id";
    static private final String USER_NAME = "user_name";
    static private final String USER_EMAIL = "user_email";
    static private final String USER_MOBILE = "user_mobile";
    static private final String JOURNEY_DATE = "journey_date";
    static private final String ROUTE_ID = "route_id";


    public SharedPreference(Context context) {
        userPreference = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);

    }

    @Override
    public void saveUser() {

    }

    @Override
    public void saveDate(String date) {
        SharedPreferences.Editor editor = userPreference.edit();
        editor.putString(JOURNEY_DATE,date);
        editor.apply();
    }

    @Override
    public void getUser() {

    }

    @Override
    public String getDate() {
        return userPreference.getString(JOURNEY_DATE,"");
    }

    @Override
    public void saveRoute(String route) {

    }

    @Override
    public String getRoute() {
        return userPreference.getString(ROUTE_ID,"1");
    }
}
