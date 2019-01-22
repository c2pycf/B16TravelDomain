package com.example.fang.b16traveldomain.model.dataResource;

import android.content.Context;

import com.example.fang.b16traveldomain.model.dataResource.localDataResource.LocalUserResource;
import com.example.fang.b16traveldomain.model.dataResource.localDataResource.SharedPreference;

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
        mLocalUserResource.getDate();;

    }
}
