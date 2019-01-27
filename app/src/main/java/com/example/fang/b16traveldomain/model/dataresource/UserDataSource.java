package com.example.fang.b16traveldomain.model.dataresource;

import android.content.Context;

import com.example.fang.b16traveldomain.model.dataresource.localdataresource.LocalUserResource;
import com.example.fang.b16traveldomain.model.dataresource.localdataresource.SharedPreference;

public class UserDataSource implements UserRepository{
    LocalUserResource mLocalUserResource;

    public UserDataSource(Context context) {
        this.mLocalUserResource = new SharedPreference(context);
    }

    @Override
    public void saveUser() {
        mLocalUserResource.saveUser();
    }

    @Override
    public void saveDate(String date) {
        mLocalUserResource.saveDate(date);

    }

    @Override
    public void getUser() {
        mLocalUserResource.getUser();

    }

    @Override
    public void getDate() {
        mLocalUserResource.getDate();

    }

    @Override
    public void saveRoute(String route) {
        mLocalUserResource.saveRoute(route);
    }

    @Override
    public String getRoute() {
        return mLocalUserResource.getRoute();
    }
}
