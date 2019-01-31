package com.example.fang.b16traveldomain.model.dataresource;

import android.content.Context;

import com.example.fang.b16traveldomain.model.dataresource.localdataresource.LocalUserResource;
import com.example.fang.b16traveldomain.model.dataresource.localdataresource.SharedPreference;

class UserDataSource(context : Context) : UserRepository{
    lateinit var  mLocalUserResource:LocalUserResource

    init {
        this.mLocalUserResource = SharedPreference (context)
    }

    override fun saveUser() {
        mLocalUserResource.saveUser()
    }

    override fun saveDate(date : String) {
        mLocalUserResource.saveDate(date)
    }

    override fun getUser() {
        mLocalUserResource.getUser()
    }

    override fun getDate() : String{
        return mLocalUserResource.getDate()
    }

    override fun saveRoute(route:String) {
        mLocalUserResource.saveRoute(route)
    }

    override fun getRoute() :String{
        return mLocalUserResource.getRoute()
    }
}
