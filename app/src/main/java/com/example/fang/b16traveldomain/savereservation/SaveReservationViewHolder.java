package com.example.fang.b16traveldomain.savereservation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.fang.b16traveldomain.model.Passenger;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.TicketInforDataResource;
import com.example.fang.b16traveldomain.model.dataresource.TicketInforRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class SaveReservationViewHolder extends AndroidViewModel {
    private TicketInforDataResource ticketInforDataResource;
    LiveData<List<TicketInformation>> ticketLists;


    public SaveReservationViewHolder(@NonNull Application application) {
        super(application);
        ticketInforDataResource = new TicketInforRepository(application);
        ticketLists = ticketInforDataResource.getAllTicketInfor();

    }

    void saveTickets(TicketInformation ticketInformation){
        ticketInforDataResource.saveTicketInfor(ticketInformation);
    }

    void delete(TicketInformation ticketInformation){
        ticketInforDataResource.deleteTicketInfor(ticketInformation);
    }

    List<Passenger> getPassengers(String time) throws ExecutionException, InterruptedException {
        return ticketInforDataResource.getPassengers(time);
    }

    LiveData<List<TicketInformation>> getTicketLists()
        {return ticketLists;}
}
