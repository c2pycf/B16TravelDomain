package com.example.fang.b16traveldomain.model.dataresource;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.fang.b16traveldomain.model.Passenger;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.localdataresource.PassengerDAO;
import com.example.fang.b16traveldomain.model.dataresource.localdataresource.TicketInforDAO;
import com.example.fang.b16traveldomain.model.dataresource.localdataresource.TravelDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TicketInforRepository implements TicketInforDataResource {

    private TravelDatabase travelDatabase;
    private PassengerDAO passengerDAO;
    private TicketInforDAO ticketInforDAO;
    private LiveData<List<TicketInformation>> ticketsList;

    public TicketInforRepository(Application application) {
        this.travelDatabase = TravelDatabase.getDatabase(application);
        this.passengerDAO = travelDatabase.passengerDAO();
        this.ticketInforDAO = travelDatabase.ticketInforDAO();
        ticketsList = ticketInforDAO.getAllTicketInfor();
    }

    @Override
    public void savePassenger(Passenger passenger) {

    }

    @Override
    public void updatePassenger(String seat) {

    }

    @Override
    public void saveTicketInfor(TicketInformation ticketInformation) {
       new insertTicketInforAsync(passengerDAO,ticketInforDAO).execute(ticketInformation);
    }


    @Override
    public void updateTicketInfor(TicketInformation ticketInformation) {

    }

    @Override
    public void deleteTicketInfor(TicketInformation ticketInformation) {
        new deleteTicketInforAsync(passengerDAO,ticketInforDAO).execute(ticketInformation);
    }

    @Override
    public LiveData<List<TicketInformation>> getAllTicketInfor() {
        return ticketsList;
    }

    @Override
    public List<Passenger> getPassengers(String orderTime) throws ExecutionException, InterruptedException {
        return new getPassengersInforAsync(passengerDAO,ticketInforDAO).execute(orderTime).get();
    }

    static private class insertTicketInforAsync extends AsyncTask<TicketInformation,Void,Void>{
        PassengerDAO passengerDAO;
        TicketInforDAO ticketInforDAO;

        public insertTicketInforAsync(PassengerDAO passengerDAO, TicketInforDAO ticketInforDAO) {
            this.passengerDAO = passengerDAO;
            this.ticketInforDAO = ticketInforDAO;
        }

        @Override
        protected Void doInBackground(TicketInformation... ticketInformations) {
            ticketInforDAO.insertTicketInfor(ticketInformations[0]);
            for(int i=0;i<ticketInformations[0].getPassengers().size();i++){
                Passenger passenger = ticketInformations[0].getPassanger(i);
                passenger.setPorderTime(ticketInformations[0].getOrder_time());
                passengerDAO.insert(passenger);
            }

            return null;
        }
    }

    static private class deleteTicketInforAsync extends AsyncTask<TicketInformation,Void,Void>{
        PassengerDAO passengerDAO;
        TicketInforDAO ticketInforDAO;

        public deleteTicketInforAsync(PassengerDAO passengerDAO, TicketInforDAO ticketInforDAO) {
            this.passengerDAO = passengerDAO;
            this.ticketInforDAO = ticketInforDAO;
        }

        @Override
        protected Void doInBackground(TicketInformation... ticketInformations) {
            ticketInforDAO.deleteTicketInfor(ticketInformations[0]);

            return null;
        }
    }

    static private class getPassengersInforAsync extends AsyncTask<String,Void,List<Passenger>>{
        PassengerDAO passengerDAO;
        TicketInforDAO ticketInforDAO;

        public getPassengersInforAsync(PassengerDAO passengerDAO, TicketInforDAO ticketInforDAO) {
            this.passengerDAO = passengerDAO;
            this.ticketInforDAO = ticketInforDAO;
        }

        @Override
        protected List<Passenger> doInBackground(String... ordertime) {
            return passengerDAO.getPassengers(ordertime[0]);
        }
    }
}
