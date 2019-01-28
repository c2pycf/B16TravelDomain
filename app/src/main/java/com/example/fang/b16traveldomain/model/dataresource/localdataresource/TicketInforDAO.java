package com.example.fang.b16traveldomain.model.dataresource.localdataresource;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fang.b16traveldomain.model.TicketInformation;

import java.util.List;

@Dao
public interface TicketInforDAO {
    @Insert
    void insertTicketInfor(TicketInformation ticketInformation);

    @Update
    void updateTicketInfor(TicketInformation ticketInformation);

    @Query ("DELETE FROM ticket_information")
    void clearTicketInfor();

    @Delete
    void deleteTicketInfor(TicketInformation ticketInformation);

    @Query("SELECT * FROM ticket_information ORDER BY order_time")
    LiveData<List<TicketInformation>> getAllTicketInfor();


}
