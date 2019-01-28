package com.example.fang.b16traveldomain.model.dataresource;

import android.arch.lifecycle.LiveData;

import com.example.fang.b16traveldomain.model.Passenger;
import com.example.fang.b16traveldomain.model.TicketInformation;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TicketInforDataResource {

    void savePassenger(Passenger passenger);

    void updatePassenger(String seat);

    void saveTicketInfor(TicketInformation ticketInformation);

    void deleteTicketInfor(TicketInformation ticketInformation);

    void updateTicketInfor(TicketInformation ticketInformation);

    LiveData<List<TicketInformation>> getAllTicketInfor();

    List<Passenger> getPassengers(String orderTime) throws ExecutionException, InterruptedException;




}
