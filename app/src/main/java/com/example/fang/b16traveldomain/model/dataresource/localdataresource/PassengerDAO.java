package com.example.fang.b16traveldomain.model.dataresource.localdataresource;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fang.b16traveldomain.model.Passenger;

import java.util.List;

@Dao
public interface PassengerDAO {
    @Insert
    void insert(Passenger passenger);

    @Update
    void update(Passenger passenger);

    @Query("DELETE FROM passenger")
    void deleteAll();

    @Query("SELECT * FROM passenger WHERE porder_time=:orderTime")
    List<Passenger> getPassengers(String orderTime);

}
